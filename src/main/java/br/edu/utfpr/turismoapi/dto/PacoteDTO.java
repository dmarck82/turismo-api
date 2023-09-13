package br.edu.utfpr.turismoapi.dto;

import br.edu.utfpr.turismoapi.models.Passeio;
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

public class PacoteDTO {
    
    private Passeio passeio;

}
