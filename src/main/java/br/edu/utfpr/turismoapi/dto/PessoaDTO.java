package br.edu.utfpr.turismoapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PessoaDTO{
    
    private String nome;    
    private String email;
    private String telefone;
    private LocalDate aniversario;
    private String identificacao;
    private String senha;

}
