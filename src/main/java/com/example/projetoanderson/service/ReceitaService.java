package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Receita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceitaService {
    public List<Receita> listarReceita();

    public Receita atualizar(Receita receita, Long id);

    public boolean deletar(Long id);

    public Receita criar(Receita receita);
}
