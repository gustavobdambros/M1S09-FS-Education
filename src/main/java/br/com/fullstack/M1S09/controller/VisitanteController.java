package br.com.fullstack.M1S09.controller;

import br.com.fullstack.M1S09.entities.VisitanteEntity;
import br.com.fullstack.M1S09.request.VisitanteRequest;
import br.com.fullstack.M1S09.service.VisitanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    private final VisitanteService visitanteService;

    public VisitanteController(VisitanteService visitanteService) {
        this.visitanteService = visitanteService;
    }

    @PostMapping
    public VisitanteEntity salvarVisitante(
            @RequestBody VisitanteRequest visitanteEntity
    ) {
        return visitanteService.salvarVisitante(
                new VisitanteEntity(
                        visitanteEntity.getNome(),
                        visitanteEntity.getTelefone()
                ));
    }

    @GetMapping
    public List<VisitanteEntity> listarVisitantes() {
        return visitanteService.listarVisitantes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVisitante (@PathVariable String id) {
        return visitanteService.deletarVisitante(id);
    }

    // Exercício 6, PUT Utilizando Query
    @PutMapping("/q")
    public VisitanteEntity atualizarVisitanteQuery(
            @RequestBody VisitanteRequest visitanteEntity
    ) {
        return visitanteService.atualizarVisitanteQuery(
                new VisitanteEntity(
                        visitanteEntity.getId(),
                        visitanteEntity.getNome(),
                        visitanteEntity.getTelefone()
                ));
    }

    @PutMapping
    public VisitanteEntity atualizaVisitante(
            @RequestBody VisitanteRequest visitanteEntity
    ) {
        return visitanteService.atualizarVisitante(
                new VisitanteEntity(
                        visitanteEntity.getId(),
                        visitanteEntity.getNome(),
                        visitanteEntity.getTelefone()
                ));
    }
}
