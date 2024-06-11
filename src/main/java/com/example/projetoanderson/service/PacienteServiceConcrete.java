package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Paciente;
import com.example.projetoanderson.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteServiceConcrete implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarPaciente() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente atualizar(Paciente paciente, Long id) {
        if (pacienteRepository.existsById(id)) {
            paciente.setIdPaciente(id);
            return pacienteRepository.save(paciente);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (id <= 0) {
            return false;
        }
        if (!pacienteRepository.existsById(id)) {
            return false;
        }
        pacienteRepository.deleteById(id);
        return true;
    }

    @Override
    public Paciente criar(Paciente paciente) {
         return pacienteRepository.save(paciente);
    }
}
