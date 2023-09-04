package br.edu.utfpr.turismoapi.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.turismoapi.models.Pessoa;
import br.edu.utfpr.turismoapi.repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepository;
    /*
    * Obter todas as pessoas do banco
    */
    @GetMapping(value = {"", "/"})
    public String getall(){
        return "Aqui estão todas as pessoas";
    }

    /*
     * Obter 1 pessoa por ID
     */
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id){
        return "Aqui é a pessoa " + id;
    }

    /*
     * Inserir 1 pessoa por ID
     */
    @PostMapping("")
    public Pessoa create(){
        var pes = new Pessoa();
        pes.setNome("Douglas Marcondes");
        pes.setEmail("douglas.marcondes@gmail.com");
        pes.setNascimento(LocalDateTime.now());
        
        pessoaRepository.save(pes);
        
        return pes;
    }

    /*
     * Atualizar 1 pessoa por ID
     */
    @PutMapping("/{id}")
    public String update(@PathVariable Long id){
        return "Pessoa " + id + " atualizada";
    }

    /*
     * Deletar 1 pessoa por ID
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return "Pessoa " + id + " deletada";
    }

}
