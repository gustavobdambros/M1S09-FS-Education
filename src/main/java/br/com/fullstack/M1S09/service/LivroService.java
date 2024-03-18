package br.com.fullstack.M1S09.service;

import br.com.fullstack.M1S09.entities.LivroEntity;
import br.com.fullstack.M1S09.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    // Método para salvar o Livro (POST)
    public LivroEntity salvarLivro(LivroEntity livroEntity) {
        return livroRepository.save(livroEntity);
    }

    // Método para listar os Livros (GET)
    public List<LivroEntity> listarLivros() {
        return livroRepository.findAll();
    }

    // Método para deletar os Livros (DELETE)
    public ResponseEntity<?> deletarLivro(String id) {
        if (!livroRepository.existsById(Long.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O livro com ID " + id + " informado não foi encontrado.");
        }
        livroRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body("Livro com o ID " + id + " deletado com sucesso.");
    }

    // Método para atualizar os Livros (PUT)
    public LivroEntity atualizarLivro(LivroEntity livroEntity) {
        // Verifica se o livro existe no banco de dados
        Long id = livroEntity.getId();
        if (id == null || !livroRepository.existsById(id)) {
            throw new IllegalArgumentException("Livro com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o livro
        return livroRepository.save(livroEntity);
    }

    // Método para atualizar os Livros (PUT) utilizando Query - Exercício 6
    public LivroEntity atualizarLivroQuery(LivroEntity livroEntity) {
        // Verifica se o livro existe no banco de dados
        Long id = livroEntity.getId();
        if (id == null || !livroRepository.existsById(id)) {
            throw new IllegalArgumentException("Livro com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o livro
        return livroRepository.save(livroEntity);
    }
}
