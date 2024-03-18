package br.com.fullstack.M1S09.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VisitanteRequest {
    private Long id;
    private String nome;
    private String telefone;

}
