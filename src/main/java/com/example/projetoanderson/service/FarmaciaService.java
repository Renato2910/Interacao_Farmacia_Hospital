package com.example.projetoanderson.service;

import com.example.projetoanderson.model.Farmacia;
import com.example.projetoanderson.model.Paciente;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FarmaciaService {
    public List<Farmacia> listarFarmacia();

    public Farmacia atualizar(Farmacia farmacia, Long id);

    public boolean deletar(Long id);

    public Farmacia criar(Farmacia farmacia);
}
