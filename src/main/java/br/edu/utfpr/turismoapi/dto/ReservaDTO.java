package br.edu.utfpr.turismoapi.dto;

import java.time.LocalDateTime;

import br.edu.utfpr.turismoapi.models.Pacote;
import br.edu.utfpr.turismoapi.models.Pessoa;
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
    
    private Pacote pacote;
    private Pessoa pessoa;
    private LocalDateTime data;
}