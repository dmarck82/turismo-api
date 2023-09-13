package br.edu.utfpr.turismoapi.dto;

import java.util.ArrayList;
import java.util.List;

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
    
    private double preco;
    private List<Passeio> passeios = new ArrayList<>();
}
