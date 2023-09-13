package br.edu.utfpr.turismoapi.dto;

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

public class PasseioDTO {
    
    private String destino;
    private String itinerario;
    private double preco;
}
