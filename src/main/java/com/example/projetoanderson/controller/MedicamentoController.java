package com.example.projetoanderson.controller;
import com.example.projetoanderson.model.Medicamento;
import com.example.projetoanderson.service.MedicamentoServiceConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoServiceConcrete medicamentoServiceConcrete;

    public MedicamentoController(MedicamentoServiceConcrete medicamentoServiceConcrete) {
        super();
        this.medicamentoServiceConcrete = medicamentoServiceConcrete;
    }

    @GetMapping(path = "/listarMedicamento")
    public List<Medicamento> listarMedicamento() {
        return medicamentoServiceConcrete.listarMedicamento();
    }

    @PostMapping(path = "/cadastrarMedicamento")
    public ResponseEntity<Medicamento> cadastrarMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento createdMedicamento = medicamentoServiceConcrete.criar(medicamento);
        return new ResponseEntity<>(createdMedicamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Medicamento medicamento, @PathVariable Long id) {
        if (medicamentoServiceConcrete.atualizar(medicamento, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(medicamento);
        }
    }

    @DeleteMapping("/deletarMedicamento/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deleted = medicamentoServiceConcrete.deletar(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

