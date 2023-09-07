package br.edu.utfpr.turismoapi.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//poderia ter usado @Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="tb_pessoa")
public class Pessoa extends BaseEntity{
    
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "aniversario", nullable = true)
    private LocalDate aniversario;

    @Column(name = "identificacao", length = 20, nullable = false)
    private String identificacao;

    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

}
