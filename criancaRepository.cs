using dominio;
using Microsoft.EntityFrameworkCore;

namespace repositorio;

public class CriancaRepository : ICriancaRepository
{
    private readonly DbContext _context;

    public CriancaRepository(DbContext context)
    {
        _context = context;
    }

    public void Criar(Crianca crianca)
    {
        _context.Set<Crianca>().Add(crianca);
        _context.SaveChanges();
    }

    public void Atualizar(Crianca crianca)
    {
        _context.Set<Crianca>().Update(crianca);
        _context.SaveChanges();
    }

    public Crianca BuscarPorCpf(string cpf)
    {
        return _context.Set<Crianca>().FirstOrDefault(c => c.Cpf == cpf);
    }

    public List<Crianca> BuscarTodas()
    {
        return _context.Set<Crianca>().ToList();
    }
}
