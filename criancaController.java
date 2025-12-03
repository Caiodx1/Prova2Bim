package api;

import application.CriancaService;
import dominio.Crianca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criancas")
public class CriancaController {

    @Autowired
    private CriancaService service;

    @PostMapping
    public ResponseEntity<Crianca> criar(@RequestBody Crianca crianca) {
        return ResponseEntity.ok(service.criar(crianca));
    }

    @PutMapping
    public ResponseEntity<Crianca> atualizar(@RequestBody Crianca crianca) {
        return ResponseEntity.ok(service.atualizar(crianca));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Crianca> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<List<Crianca>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }
}