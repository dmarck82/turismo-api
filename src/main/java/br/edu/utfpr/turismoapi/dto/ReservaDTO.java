package br.edu.utfpr.turismoapi.dto;

import java.time.LocalDateTime;

import br.edu.utfpr.turismoapi.models.Pacote;
import br.edu.utfpr.turismoapi.models.Pessoa;
import jakarta.validation.constraints.FutureOrPresent;
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

public class ReservaDTO{
    
    @NotBlank
    private Pacote pacote;

    @NotBlank
    private Pessoa pessoa;

    @NotBlank
    @FutureOrPresent
    private LocalDateTime data;
}