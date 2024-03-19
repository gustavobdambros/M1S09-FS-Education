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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private LivroEntity livroId;

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private MembroEntity membroId;

    private Date dataEmprestimo;
    private Date dataDevolucao;

    public EmprestimoEntity(LivroEntity livroId, MembroEntity membroId, Date dataEmprestimo, Date dataDevolucao) {
        this.livroId = livroId;
        this.membroId = membroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public EmprestimoEntity(Long id, LivroEntity livroId, MembroEntity membroId, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.livroId = livroId;
        this.membroId = membroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
