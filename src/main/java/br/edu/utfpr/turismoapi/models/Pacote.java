package br.edu.utfpr.turismoapi.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

@Entity
@Table(name = "tb_pacote")
public class Pacote extends BaseEntity {
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "preco")
    private Double preco;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pacote_id")
    private List<Passeio> passeios = new ArrayList<>();
    
}
