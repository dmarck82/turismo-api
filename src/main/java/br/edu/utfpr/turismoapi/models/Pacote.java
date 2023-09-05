package br.edu.utfpr.turismoapi.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pacote extends BaseEntity {
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pacote")
    private List<Reserva> reservas = new ArrayList<Reserva>();

    @ManyToOne
    @JoinColumn(name = "passeio_id")
    private Passeio passeio;
}
