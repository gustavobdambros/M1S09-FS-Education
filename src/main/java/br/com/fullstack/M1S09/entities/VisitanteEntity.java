package br.com.fullstack.M1S09.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "visitante")
@Entity
@Data
@NoArgsConstructor
public class VisitanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;

    public VisitanteEntity(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public VisitanteEntity(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
}
