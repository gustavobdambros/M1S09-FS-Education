package br.com.fullstack.M1S09.service;

import br.com.fullstack.M1S09.entities.BibliotecarioEntity;
import br.com.fullstack.M1S09.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    // Método para salvar o Bibliotecário (POST)
    public BibliotecarioEntity salvarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioRepository.save(bibliotecarioEntity);
    }

    // Método para listar os Bibliotecários (GET)
    public List<BibliotecarioEntity> listarBibliotecario() {
        return bibliotecarioRepository.findAll();
    }

    // Método para deletar os Bibliotecários (DELETE) - Utilização de status somente em delete para demonstração
    public ResponseEntity<?> deletarBibliotecario(String id) {
        if (!bibliotecarioRepository.existsById(Long.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O bibliotecário com ID " + id + " informado não foi encontrado.");
        }
        bibliotecarioRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body("Bibliotecário com o ID " + id + " deletado com sucesso.");
    }

    // Método para atualizar os Bibliotecários (PUT)
    public BibliotecarioEntity atualizarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        // Verifica se o bibliotecário existe no banco de dados
        Long id = bibliotecarioEntity.getId();
        if (id == null || !bibliotecarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o bibliotecário
        return bibliotecarioRepository.save(bibliotecarioEntity);
    }

    // Método para atualizar os Bibliotecários (PUT) utilizando Query - Exercício 6
    public BibliotecarioEntity atualizarBibliotecarioQuery(BibliotecarioEntity bibliotecarioEntity) {
        // Verifica se o bibliotecário existe no banco de dados
        Long id = bibliotecarioEntity.getId();
        if (id == null || !bibliotecarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o bibliotecário
        return bibliotecarioRepository.save(bibliotecarioEntity);
    }
}
