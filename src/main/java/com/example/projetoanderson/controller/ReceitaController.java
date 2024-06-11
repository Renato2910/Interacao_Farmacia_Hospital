package com.example.projetoanderson.controller;

import com.example.projetoanderson.model.Receita;
import com.example.projetoanderson.service.ReceitaServiceConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaServiceConcrete receitaServiceConcrete;

    public ReceitaController(ReceitaServiceConcrete receitaServiceConcrete) {
        this.receitaServiceConcrete = receitaServiceConcrete;
    }

    @GetMapping(path = "/listarReceita")
    public List<Receita> listarReceita() {
        List<Receita> receitas = receitaServiceConcrete.listarReceita();
        receitas.sort((r1, r2) -> Long.compare(r2.getId(), r1.getId()));
        return receitas;
    }

    @PostMapping(path = "/cadastrarReceita")
    public ResponseEntity<Receita> cadastrarReceita(@RequestBody Receita receita) {
        Receita createdReceita = receitaServiceConcrete.criar(receita);
        return new ResponseEntity<>(createdReceita, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Receita receita, @PathVariable Long id) {
        if (receitaServiceConcrete.atualizar(receita, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(receita);
        }
    }

    @DeleteMapping("/deletarReceita/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deleted = receitaServiceConcrete.deletar(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
