package com.example.projetoanderson.service;

import com.example.projetoanderson.model.Medico;
import com.example.projetoanderson.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MedicoServiceConcrete implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> listarMedico() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico atualizar(Medico medico, Long id) {
        if (medicoRepository.existsById(id)) {
            medico.setIdMedico(id);
            return medicoRepository.save(medico);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (id <= 0) {
            return false;
        }
        if (!medicoRepository.existsById(id)) {
            return false;
        }
        medicoRepository.deleteById(id);
        return true;
    }

    @Override
    public Medico criar(Medico medico) {
        return medicoRepository.save(medico);
    }
}
