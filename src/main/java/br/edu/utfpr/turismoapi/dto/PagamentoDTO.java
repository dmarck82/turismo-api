package br.edu.utfpr.turismoapi.dto;

import br.edu.utfpr.turismoapi.models.Reserva;
import jakarta.validation.constraints.NotBlank;
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

public class PagamentoDTO {

    @NotBlank
    private double valor;

    @NotBlank
    private Reserva reserva;
    
}
