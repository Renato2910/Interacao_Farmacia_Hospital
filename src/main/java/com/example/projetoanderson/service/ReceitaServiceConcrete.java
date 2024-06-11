package com.example.projetoanderson.service;

import com.example.projetoanderson.model.Paciente;
import com.example.projetoanderson.model.Receita;
import com.example.projetoanderson.repository.PacienteRepository;
import com.example.projetoanderson.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReceitaServiceConcrete implements ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Override
    public List<Receita> listarReceita() {
        return receitaRepository.findAll();
    }

    @Override
    public Receita atualizar(Receita receita, Long id) {
        if (receitaRepository.existsById(id)) {
            receita.setId(id);
            return receitaRepository.save(receita);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (id <= 0) {
            return false;
        }
        if (!receitaRepository.existsById(id)) {
            return false;
        }
        receitaRepository.deleteById(id);
        return true;
    }

    @Override
    public Receita criar(Receita receita) {
        return receitaRepository.save(receita);
    }
}
