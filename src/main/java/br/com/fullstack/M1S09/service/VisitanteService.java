package br.com.fullstack.M1S09.service;

import br.com.fullstack.M1S09.entities.VisitanteEntity;
import br.com.fullstack.M1S09.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;

    // Método para salvar o Visitante (POST)
    public VisitanteEntity salvarVisitante(VisitanteEntity visitanteEntity) {
        return visitanteRepository.save(visitanteEntity);
    }

    // Método para listar os Visitantes (GET)
    public List<VisitanteEntity> listarVisitantes() {
        return visitanteRepository.findAll();
    }

    // Método para deletar os Visitantes (DELETE)
    public ResponseEntity<?> deletarVisitante(String id) {
        if (!visitanteRepository.existsById(Long.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O visitante com ID " + id + " informado não foi encontrado.");
        }
        visitanteRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body("Visitante com o ID " + id + " deletado com sucesso.");
    }

    // Método para atualizar os Visitantes (PUT)
    public VisitanteEntity atualizarVisitante(VisitanteEntity visitanteEntity) {
        // Verifica se o visitante existe no banco de dados
        Long id = visitanteEntity.getId();
        if (id == null || !visitanteRepository.existsById(id)) {
            throw new IllegalArgumentException("Visitante com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o visitante
        return visitanteRepository.save(visitanteEntity);
    }

    // Método para atualizar os Visitantes (PUT) utilizando Query - Exercício 6
    public VisitanteEntity atualizarVisitanteQuery(VisitanteEntity visitanteEntity) {
        // Verifica se o visitante existe no banco de dados
        Long id = visitanteEntity.getId();
        if (id == null || !visitanteRepository.existsById(id)) {
            throw new IllegalArgumentException("Visitante com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o visitante
        return visitanteRepository.save(visitanteEntity);
    }
}
