package repositorio;

import dominio.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CriancaRepository extends JpaRepository<Crianca, Long> {

    Optional<Crianca> findByCpf(String cpf);
}