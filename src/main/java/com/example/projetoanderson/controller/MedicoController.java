package com.example.projetoanderson.controller;
import com.example.projetoanderson.model.Medico;
import com.example.projetoanderson.service.MedicoServiceConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoServiceConcrete medicoServiceConcrete;

    public MedicoController(MedicoServiceConcrete medicoServiceConcrete) {
        super();
        this.medicoServiceConcrete = medicoServiceConcrete;
    }

    @GetMapping(path = "/listarMedico")
    public List<Medico> listarMedico() {
        return medicoServiceConcrete.listarMedico();
    }

    @PostMapping("/cadastrarMedico")
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        Medico createdMedico = medicoServiceConcrete.criar(medico);
        return new ResponseEntity<>(createdMedico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Medico medico, @PathVariable Long id) {
        if (medicoServiceConcrete.atualizar(medico, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(medico);
        }
    }

    @DeleteMapping("/deletarMedico/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deleted = medicoServiceConcrete.deletar(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
