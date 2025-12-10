using dominio;

namespace repositorio;

public interface ICriancaRepository
{
    void Criar(Crianca crianca);
    void Atualizar(Crianca crianca);
    Crianca BuscarPorCpf(string cpf);
    List<Crianca> BuscarTodas();
}
