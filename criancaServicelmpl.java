package application;

import dominio.Crianca;
import repositorio.CriancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriancaServiceImpl implements CriancaService {

    @Autowired
    private CriancaRepository repository;

    @Override
    public Crianca criar(Crianca crianca) {

        if (repository.findByCpf(crianca.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        if (crianca.isTemAlergia() &&
                (crianca.getDescricaoAlergia() == null ||
                 crianca.getDescricaoAlergia().trim().isEmpty())) {

            throw new RuntimeException("Descrição da alergia é obrigatória para crianças com alergia!");
        }

        return repository.save(crianca);
    }

    @Override
    public Crianca atualizar(Crianca crianca) {

        Crianca existente = repository.findByCpf(crianca.getCpf())
                .orElseThrow(() -> new RuntimeException("CPF não encontrado!"));

        if (crianca.isTemAlergia() &&
                (crianca.getDescricaoAlergia() == null ||
                 crianca.getDescricaoAlergia().trim().isEmpty())) {

            throw new RuntimeException("Descrição da alergia é obrigatória!");
        }

        crianca.setId(existente.getId());
        return repository.save(crianca);
    }

    @Override
    public Crianca buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Criança não encontrada com esse CPF"));
    }

    @Override
    public List<Crianca> buscarTodas() {
        return repository.findAll();
    }
}