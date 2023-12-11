package br.edu.utfpr.turismoapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.edu.utfpr.turismoapi.dto.PessoaDTO;
import br.edu.utfpr.turismoapi.models.Pessoa;
import br.edu.utfpr.turismoapi.repositories.PessoaRepository;

import java.time.LocalDate;

@Component
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem pessoas cadastradas
        if (pessoaRepository.count() == 0) {
            cadastrarPessoaInicial();
        }
    }

    private void cadastrarPessoaInicial() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Douglas Marcondes");
        pessoaDTO.setEmail("douglas.marcondes@gmail.com");
        pessoaDTO.setTelefone("+5545998217562");
        pessoaDTO.setAniversario(LocalDate.parse("1995-04-17"));
        pessoaDTO.setIdentificacao("Administrador");
        pessoaDTO.setSenha("resende123");

        Pessoa pessoa = converterDTOparaEntidade(pessoaDTO);
        pessoaRepository.save(pessoa);
    }

    private Pessoa converterDTOparaEntidade(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        pessoa.setAniversario(pessoaDTO.getAniversario());
        pessoa.setIdentificacao(pessoaDTO.getIdentificacao());
        // A senha deve ser criptografada antes de ser armazenada no banco de dados
        pessoa.setSenha(passwordEncoder.encode(pessoaDTO.getSenha()));

        return pessoa;
    }
}
