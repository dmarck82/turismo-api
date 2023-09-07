package br.edu.utfpr.turismoapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pacote")
public class Pacote extends BaseEntity {
    
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pacote")
    //private List<Reserva> reservas = new ArrayList<Reserva>();

    @ManyToOne
    @JoinColumn(name = "passeio_id")
    private Passeio passeio;

    
}
