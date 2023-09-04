package br.edu.utfpr.turismoapi.models;

import java.time.LocalDateTime;

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
@Table(name="tb_person")
public class Pessoa extends BaseEntity{
    
    @Column(name = "name", length = 150, nullable = false)
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "birth")
    private LocalDateTime nascimento; 
}
