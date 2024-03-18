package br.com.fullstack.M1S09.controller;


import br.com.fullstack.M1S09.entities.BibliotecarioEntity;
import br.com.fullstack.M1S09.request.BibliotecarioRequest;
import br.com.fullstack.M1S09.service.BibliotecarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;

    public BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @PostMapping
    public BibliotecarioEntity salvarBibliotecario(
            @RequestBody BibliotecarioRequest bibliotecarioEntity
    ) {
        return bibliotecarioService.salvarBibliotecario(
                new BibliotecarioEntity(
                        bibliotecarioEntity.getNome(),
                        bibliotecarioEntity.getEmail(),
                        bibliotecarioEntity.getSenha()
                ));
    }

    @GetMapping
    public List<BibliotecarioEntity> listarBibliotecario() {
        return bibliotecarioService.listarBibliotecario();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarBibliotecario (@PathVariable String id) {
        return bibliotecarioService.deletarBibliotecario(id);
    }

    // Exercício 6, PUT Utilizando Query
    @PutMapping("/q")
    public BibliotecarioEntity atualizarBibliotecarioQuery(
            @RequestBody BibliotecarioRequest bibliotecarioEntity
    ) {
        return bibliotecarioService.atualizarBibliotecarioQuery(
                new BibliotecarioEntity(
                        bibliotecarioEntity.getId(),
                        bibliotecarioEntity.getNome(),
                        bibliotecarioEntity.getEmail(),
                        bibliotecarioEntity.getSenha()
                ));
    }

    @PutMapping
    public BibliotecarioEntity atualizaBibliotecario(
            @RequestBody BibliotecarioRequest bibliotecarioEntity
    ) {
        return bibliotecarioService.atualizarBibliotecario(
                new BibliotecarioEntity(
                        bibliotecarioEntity.getId(),
                        bibliotecarioEntity.getNome(),
                        bibliotecarioEntity.getEmail(),
                        bibliotecarioEntity.getSenha()
                ));
    }
}