using application;
using dominio;
using Microsoft.AspNetCore.Mvc;

namespace api;

[ApiController]
[Route("criancas")]
public class CriancaController : ControllerBase
{
    private readonly ICriancaService _service;

    public CriancaController(ICriancaService service)
    {
        _service = service;
    }

    [HttpPost]
    public ActionResult<Crianca> Criar([FromBody] Crianca crianca)
    {
        return Ok(_service.Criar(crianca));
    }

    [HttpPut]
    public ActionResult<Crianca> Atualizar([FromBody] Crianca crianca)
    {
        return Ok(_service.Atualizar(crianca));
    }

    [HttpGet("{cpf}")]
    public ActionResult<Crianca> BuscarPorCpf(string cpf)
    {
        return Ok(_service.BuscarPorCpf(cpf));
    }

    [HttpGet]
    public ActionResult<List<Crianca>> BuscarTodas()
    {
        return Ok(_service.BuscarTodas());
    }
}
