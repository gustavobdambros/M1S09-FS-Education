package br.com.fullstack.M1S09.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "emprestimo")
@Entity
@Data
@NoArgsConstructor
public class EmprestimoEntity {

    @Column(name = "livro_id")
    private Long livroId;

    @Column(name = "membro_id")
    private Long membroId;

    private Date dataEmprestimo;
    private Date dataDevolucao;
}
