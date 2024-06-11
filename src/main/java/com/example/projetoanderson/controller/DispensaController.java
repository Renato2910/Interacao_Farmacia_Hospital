package com.example.projetoanderson.controller;

import com.example.projetoanderson.model.Dispensa;
import com.example.projetoanderson.model.Paciente;
import com.example.projetoanderson.service.DispensaServiceConcrete;
import com.example.projetoanderson.service.PacienteServiceConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispensa")
public class DispensaController {
    @Autowired
    private DispensaServiceConcrete dispensaServiceConcrete;

    public DispensaController(DispensaServiceConcrete dispensaServiceConcrete) {
        super();
        this.dispensaServiceConcrete = dispensaServiceConcrete;
    }


    @GetMapping(path = "/listarDispensa")
    public List<Dispensa> listarDispensa() {
        return dispensaServiceConcrete.listar();
    }

    @PostMapping(path = "/cadastrarDispensa")
    public ResponseEntity<Dispensa> cadastrarDispensa(@RequestBody Dispensa dispensa) {
        Dispensa createdDispensa = dispensaServiceConcrete.criar(dispensa);
        return new ResponseEntity<>(createdDispensa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Dispensa dispensa, @PathVariable Long id) {
        if (dispensaServiceConcrete.atualizar(dispensa, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(dispensa);
        }
    }

    @DeleteMapping("/deletarDispensa/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deleted = dispensaServiceConcrete.deletar(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
