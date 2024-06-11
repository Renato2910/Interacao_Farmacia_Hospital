package com.example.projetoanderson.service;

import com.example.projetoanderson.model.Farmacia;
import com.example.projetoanderson.model.Paciente;
import com.example.projetoanderson.repository.FarmaciaRepository;
import com.example.projetoanderson.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FarmaciaServiceConcrete implements FarmaciaService {
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Override
    public List<Farmacia> listarFarmacia() {
        return farmaciaRepository.findAll();
    }

    @Override
    public Farmacia atualizar(Farmacia farmacia, Long id) {
        if (farmaciaRepository.existsById(id)) {
            farmacia.setIdFarmacia(id);
            return farmaciaRepository.save(farmacia);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (id <= 0) {
            return false;
        }
        if (!farmaciaRepository.existsById(id)) {
            return false;
        }
        farmaciaRepository.deleteById(id);
        return true;
    }

    @Override
    public Farmacia criar(Farmacia farmacia) {
        return farmaciaRepository.save(farmacia);
    }
}
