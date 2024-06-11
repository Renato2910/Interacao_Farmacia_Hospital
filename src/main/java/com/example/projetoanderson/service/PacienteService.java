package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Paciente;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface PacienteService {
    public List<Paciente> listarPaciente();

    public Paciente atualizar(Paciente paciente, Long id);

    public boolean deletar(Long id);

    public Paciente criar(Paciente paciente);
}
