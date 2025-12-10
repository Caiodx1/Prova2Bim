using dominio;
using repositorio;

namespace application;

public class CriancaService : ICriancaService
{
    private readonly ICriancaRepository _repository;

    public CriancaService(ICriancaRepository repository)
    {
        _repository = repository;
    }

    public Crianca Criar(Crianca crianca)
    {
        if (_repository.BuscarPorCpf(crianca.Cpf) != null)
            throw new Exception("CPF já cadastrado!");

        if (crianca.TemAlergia && string.IsNullOrWhiteSpace(crianca.DescricaoAlergia))
            throw new Exception("Descrição da alergia é obrigatória!");

        _repository.Criar(crianca);

        return crianca;
    }

    public Crianca Atualizar(Crianca crianca)
    {
        var existente = _repository.BuscarPorCpf(crianca.Cpf);
        if (existente == null)
            throw new Exception("CPF não encontrado!");

        if (crianca.TemAlergia && string.IsNullOrWhiteSpace(crianca.DescricaoAlergia))
            throw new Exception("Descrição da alergia é obrigatória!");

        crianca.Id = existente.Id;

        _repository.Atualizar(crianca);

        return crianca;
    }

    public Crianca BuscarPorCpf(string cpf)
    {
        var crianca = _repository.BuscarPorCpf(cpf);
        if (crianca == null)
            throw new Exception("Criança não encontrada!");

        return crianca;
    }

    public List<Crianca> BuscarTodas()
    {
        return _repository.BuscarTodas();
    }
}
