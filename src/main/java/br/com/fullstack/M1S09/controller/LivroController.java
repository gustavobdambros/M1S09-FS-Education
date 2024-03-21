package br.com.fullstack.M1S09.controller;

import br.com.fullstack.M1S09.entities.LivroEntity;
import br.com.fullstack.M1S09.request.LivroRequest;
import br.com.fullstack.M1S09.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public LivroEntity salvarLivro(
            @RequestBody LivroRequest livroEntity
    ) {
        return livroService.salvarLivro(
                new LivroEntity(
                        livroEntity.getTitulo(),
                        livroEntity.getAutor(),
                        livroEntity.getAnoPublicacao()
                ));
    }

    @GetMapping
    public List<LivroEntity> listarLivros() {
        return livroService.listarLivros();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro (@PathVariable String id) {
        return livroService.deletarLivro(id);
    }

    // Exercício 6, PUT Utilizando Query
    @PutMapping("/q")
    public LivroEntity atualizarLivroQuery(
            @RequestBody LivroRequest livroEntity
    ) {
        return livroService.atualizarLivroQuery(
                new LivroEntity(
                        livroEntity.getId(),
                        livroEntity.getTitulo(),
                        livroEntity.getAutor(),
                        livroEntity.getAnoPublicacao()
                ));
    }

    @PutMapping
    public LivroEntity atualizaLivro(
            @RequestBody LivroRequest livroEntity
    ) {
        return livroService.atualizarLivro(
                new LivroEntity(
                        livroEntity.getId(),
                        livroEntity.getTitulo(),
                        livroEntity.getAutor(),
                        livroEntity.getAnoPublicacao()
                ));
    }
}
