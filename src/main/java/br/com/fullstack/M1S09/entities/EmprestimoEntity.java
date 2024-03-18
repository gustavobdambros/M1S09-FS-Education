package br.com.fullstack.M1S09.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "emprestimo")
@Entity
@Data
@NoArgsConstructor
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "livro_id")
    private Long livroId;

    @Column(name = "membro_id")
    private Long membroId;

    private Date dataEmprestimo;
    private Date dataDevolucao;

    public EmprestimoEntity(Long livroId, Long membroId, Date dataEmprestimo, Date dataDevolucao) {
        this.livroId = livroId;
        this.membroId = membroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
