package br.edu.utfpr.turismoapi.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.turismoapi.models.Passeio;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    
    @NotNull
    private String nome;

    @NotNull
    private double preco;

    @NotEmpty
    private List<String> passeios = new ArrayList<>();
}