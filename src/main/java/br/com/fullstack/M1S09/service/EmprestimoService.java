package br.com.fullstack.M1S09.service;

import br.com.fullstack.M1S09.entities.EmprestimoEntity;
import br.com.fullstack.M1S09.repository.EmprestimoRepository;
import br.com.fullstack.M1S09.request.EmprestimoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    // Método para salvar o Emprestimo (POST)
    public EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimoEntity) {
        return emprestimoRepository.save(emprestimoEntity);
    }

    // Método para listar os Emprestimos (GET)
    public List<EmprestimoEntity> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    // Método para deletar os Emprestimos (DELETE) - Utilização de status somente em delete para demonstração
    public ResponseEntity<?> deletarEmprestimo(String id) {
        if (!emprestimoRepository.existsById(Long.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O emprestimo com ID " + id + " informado não foi encontrado.");
        }
        emprestimoRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body("Emprestimo com o ID " + id + " deletado com sucesso.");
    }

    // Método para atualizar os Emprestimos (PUT)
    public EmprestimoEntity atualizarEmprestimo(EmprestimoEntity emprestimoEntity) {
        // Verifica se o emprestimo existe no banco de dados
        Long id = emprestimoEntity.getId();
        if (id == null || !emprestimoRepository.existsById(id)) {
            throw new IllegalArgumentException("Emprestimo com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o emprestimo
        return emprestimoRepository.save(emprestimoEntity);
    }

    // Método para atualizar os Emprestimos (PUT) utilizando Query - Exercício 6
    public EmprestimoEntity atualizarEmprestimoQuery(EmprestimoEntity emprestimoEntity) {
        // Verifica se o emprestimo existe no banco de dados
        Long id = emprestimoEntity.getId();
        if (id == null || !emprestimoRepository.existsById(id)) {
            throw new IllegalArgumentException("Emprestimo com ID " + id + " não encontrado para atualização.");
        }

        // Salvar e atualizar o emprestimo
        return emprestimoRepository.save(emprestimoEntity);
    }
}
