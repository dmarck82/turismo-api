package br.edu.utfpr.turismoapi.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.turismoapi.dto.ReservaDTO;
import br.edu.utfpr.turismoapi.models.Reserva;
import br.edu.utfpr.turismoapi.repositories.ReservaRepository;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaRepository reservaRepository;

    // Obter todas as reservas do banco
    @GetMapping(value = { "", "/" })
    public List<Reserva> getAll() {
        return reservaRepository.findAll();
    }

    // Obter todas as reservas de forma paginada
    @GetMapping("/pages")
    public ResponseEntity<Page<Reserva>> getAllPage(
            @PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(reservaRepository.findAll(pageable));
    }

    // Obter um reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        Optional<Reserva> reservaOpt = reservaRepository
                .findById(UUID.fromString(id));

        return reservaOpt.isPresent()
                ? ResponseEntity.ok(reservaOpt.get())
                : ResponseEntity.notFound().build();
    }

    // Inserir 1 reserva
    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ReservaDTO reservaDTO) {
        var res = new Reserva(); // reserva que será persistido no DB
        BeanUtils.copyProperties(reservaDTO, res);

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(reservaRepository.save(res));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Falha ao criar reserva");
        }
    }

    // Atualizar 1 reserva por ID
    @PutMapping("/{id}")
    ResponseEntity<Object> update(@PathVariable String id, @RequestBody ReservaDTO reservaDTO) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Formato de UUID inválido");
        }

        // Buscando o reserva no banco de dados
        var reserva = reservaRepository.findById(uuid);

        // Verifica se ele existe
        if (reserva.isEmpty())
            return ResponseEntity
                    .notFound()
                    .build();

        var reservaToUpdate = reserva.get();
        BeanUtils.copyProperties(reservaDTO, reservaToUpdate);
        reservaToUpdate.setAtualizado_em(LocalDateTime.now());

        try {
            return ResponseEntity
                    .ok()
                    .body(reservaRepository.save(reservaToUpdate));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Falha ao atualizar o passeio.");
        }
    }

    // Deletar 1 reserva por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {

        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Formato de UUID inválido");
        }

        // Buscando o passeio no banco de dados
        var reserva = reservaRepository.findById(uuid);

        // Verifica se ele existe
        if (reserva.isEmpty())
            return ResponseEntity
                    .notFound()
                    .build();

        try {
            reservaRepository.delete(reserva.get());

            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}