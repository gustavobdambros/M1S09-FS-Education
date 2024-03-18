package br.com.fullstack.M1S09.controller;

import br.com.fullstack.M1S09.entities.MembroEntity;
import br.com.fullstack.M1S09.request.MembroRequest;
import br.com.fullstack.M1S09.service.MembroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membro")
public class MembroController {

    private final MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @PostMapping
    public MembroEntity salvarMembro(
            @RequestBody MembroRequest membroEntity
    ) {
        return membroService.salvarMembro(
                new MembroEntity(
                        membroEntity.getNome(),
                        membroEntity.getEndereco(),
                        membroEntity.getTelefone()
                ));
    }

    @GetMapping
    public List<MembroEntity> listarMembros() {
        return membroService.listarMembros();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarMembro (@PathVariable String id) {
        return membroService.deletarMembro(id);
    }

    // Exercício 6, PUT Utilizando Query
    @PutMapping("/q")
    public MembroEntity atualizarMembroQuery(
            @RequestBody MembroRequest membroEntity
    ) {
        return membroService.atualizarMembroQuery(
                new MembroEntity(
                        membroEntity.getId(),
                        membroEntity.getNome(),
                        membroEntity.getEndereco(),
                        membroEntity.getTelefone()
                ));
    }

    @PutMapping
    public MembroEntity atualizaMembro(
            @RequestBody MembroRequest membroEntity
    ) {
        return membroService.atualizarMembro(
                new MembroEntity(
                        membroEntity.getId(),
                        membroEntity.getNome(),
                        membroEntity.getEndereco(),
                        membroEntity.getTelefone()
                ));
    }

}