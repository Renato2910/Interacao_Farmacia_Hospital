package com.example.projetoanderson.controller;

import com.example.projetoanderson.model.Farmacia;
import com.example.projetoanderson.model.Paciente;
import com.example.projetoanderson.service.FarmaciaServiceConcrete;
import com.example.projetoanderson.service.PacienteServiceConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

    @Autowired
    private FarmaciaServiceConcrete farmaciaServiceConcrete;

    public FarmaciaController(FarmaciaServiceConcrete farmaciaServiceConcrete) {
        super();
        this.farmaciaServiceConcrete = farmaciaServiceConcrete;
    }

    @GetMapping(path = "/listarFarmacia")
    public List<Farmacia> listarFarmacia() {
        return farmaciaServiceConcrete.listarFarmacia();
    }

    @PostMapping(path = "/cadastrarFarmacia")
    public ResponseEntity<Farmacia> cadastrarFarmacia(@RequestBody Farmacia farmacia) {
        Farmacia createdFarmacia = farmaciaServiceConcrete.criar(farmacia);
        return new ResponseEntity<>(createdFarmacia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Farmacia farmacia, @PathVariable Long id) {
        if (farmaciaServiceConcrete.atualizar(farmacia, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(farmacia);
        }
    }

    @DeleteMapping("/deletarFarmacia/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deleted = farmaciaServiceConcrete.deletar(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
