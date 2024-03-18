package br.com.fullstack.M1S09.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LivroRequest {
    private Long id;
    private String titulo;
    private String autor;
    private String anoPublicacao;
}
