package br.edu.utfpr.turismoapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tb_reserva")
public class Reserva  extends BaseEntity{
    
    //quando o passeio será realizado
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Pessoa person;
}
