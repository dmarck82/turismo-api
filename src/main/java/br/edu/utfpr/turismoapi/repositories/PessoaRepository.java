package br.edu.utfpr.turismoapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.turismoapi.models.Pessoa;

public interface PessoaRepository extends JpaRepository <Pessoa, UUID> {
    


}
