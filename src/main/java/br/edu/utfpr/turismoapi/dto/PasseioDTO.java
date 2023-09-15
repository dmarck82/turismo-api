package br.edu.utfpr.turismoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    
    @NotBlank
    @Size(min = 2, max = 50)
    private String destino;

    @NotBlank
    @Size(min = 2, max = 150)
    private String itinerario;

    @NotBlank
    private double preco;
}
