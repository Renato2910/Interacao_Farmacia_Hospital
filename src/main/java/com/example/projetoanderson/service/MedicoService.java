package com.example.projetoanderson.service;

import com.example.projetoanderson.model.Medico;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface MedicoService {
    public List<Medico> listarMedico();

    public Medico atualizar(Medico medico, Long id);

    public boolean deletar(Long id);

    public Medico criar(Medico medico);

}
