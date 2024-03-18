package br.com.fullstack.M1S09.service;

import br.com.fullstack.M1S09.entities.MembroEntity;
import br.com.fullstack.M1S09.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    // Método para salvar o Membro (POST)
    public MembroEntity salvarMembro(MembroEntity membroEntity) {
        return membroRepository.save(membroEntity);
    }

    // Método para listar os Membros (GET)
    public List<MembroEntity> listarMembros() {
        return membroRepository.findAll();
    }

    // Método para deletar os Membros (DELETE)
    public ResponseEntity<?> deletarMembro(String id) {
        if (!membroRepository.existsById(Long.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ID " + id + " informado não foi encontrado.");
        }
        membroRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body("Usuário com o ID " + id + " deletado com sucesso.");
    }

    // Método para atualizar os Membros (PUT)
    public MembroEntity atualizarMembro(MembroEntity membroEntity) {
        // Verifica se o membro existe no banco de dados
        Long id = membroEntity.getId();
        if (id == null || !membroRepository.existsById(id)) {
            throw new IllegalArgumentException("Membro com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o membro
        return membroRepository.save(membroEntity);
    }

    // Método para atualizar os Membros (PUT) utilizando Query - Exercício 6
    public MembroEntity atualizarMembroQuery(MembroEntity membroEntity) {
        // Verifica se o membro existe no banco de dados
        Long id = membroEntity.getId();
        if (id == null || !membroRepository.existsById(id)) {
            throw new IllegalArgumentException("Membro com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o membro
        return membroRepository.save(membroEntity);
    }
}
