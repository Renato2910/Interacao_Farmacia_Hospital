package com.example.projetoanderson.controller;

import com.example.projetoanderson.model.Paciente;
import com.example.projetoanderson.service.PacienteServiceConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteServiceConcrete pacienteServiceConcrete;

    public PacienteController(PacienteServiceConcrete pacienteServiceConcrete) {
        super();
       this.pacienteServiceConcrete = pacienteServiceConcrete;
    }

    @GetMapping(path = "/listarPacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteServiceConcrete.listarPaciente();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping(path = "/cadastrarPaciente")
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteServiceConcrete.criar(paciente);
        System.out.println("OK");
        return new ResponseEntity<>(createdPaciente, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Paciente paciente, @PathVariable Long id) {
        if (pacienteServiceConcrete.atualizar(paciente, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(paciente);
        }
    }

    @DeleteMapping("/deletarPaciente/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deleted = pacienteServiceConcrete.deletar(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
