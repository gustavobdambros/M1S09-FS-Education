package br.com.fullstack.M1S09.request;

import br.com.fullstack.M1S09.entities.LivroEntity;
import br.com.fullstack.M1S09.entities.MembroEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class EmprestimoRequest {

    private Long id;
    private LivroEntity livroId;
    private MembroEntity membroId;
    private Date dataEmprestimo;
    private Date dataDevolucao;
}