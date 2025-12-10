using dominio;

namespace application;

public interface ICriancaService
{
    Crianca Criar(Crianca crianca);
    Crianca Atualizar(Crianca crianca);
    Crianca BuscarPorCpf(string cpf);
    List<Crianca> BuscarTodas();
}
