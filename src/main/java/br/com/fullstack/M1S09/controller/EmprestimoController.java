package br.com.fullstack.M1S09.controller;

import br.com.fullstack.M1S09.entities.EmprestimoEntity;
import br.com.fullstack.M1S09.request.EmprestimoRequest;
import br.com.fullstack.M1S09.service.EmprestimoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping //mapeia o método POST do REST, esse adiciona dados
    // Solicitação apenas de ID
    public EmprestimoEntity salvaEmprestimos(
            @RequestBody EmprestimoRequest emprestimoEntity //indica que o EmprestimoEntity virá no Body da requisição
    ) {
        return emprestimoService.salvarEmprestimo(
                new EmprestimoEntity(
                        emprestimoEntity.getId(),
                        emprestimoEntity.getLivroId(),
                        emprestimoEntity.getMembroId(),
                        emprestimoEntity.getDataEmprestimo(),
                        emprestimoEntity.getDataDevolucao()
                ));
    }

    @GetMapping
    public List<EmprestimoEntity> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEmprestimo(@PathVariable String id) {
        return emprestimoService.deletarEmprestimo(id);
    }

    // Exercício 6, PUT Utilizando Query
    @PutMapping("/q")
    public EmprestimoEntity atualizarEmprestimoQuery(
            @RequestBody EmprestimoRequest emprestimoEntity
    ) {
        return emprestimoService.atualizarEmprestimoQuery(
                new EmprestimoEntity(
                        emprestimoEntity.getLivroId(),
                        emprestimoEntity.getMembroId(),
                        emprestimoEntity.getDataEmprestimo(),
                        emprestimoEntity.getDataDevolucao()
                ));
    }

    @PutMapping
    public EmprestimoEntity atualizarEmprestimo(
            @RequestBody EmprestimoRequest emprestimoEntity
    ) {
        return emprestimoService.atualizarEmprestimo(
                new EmprestimoEntity(
                        emprestimoEntity.getLivroId(),
                        emprestimoEntity.getMembroId(),
                        emprestimoEntity.getDataEmprestimo(),
                        emprestimoEntity.getDataDevolucao()
                ));
    }
}