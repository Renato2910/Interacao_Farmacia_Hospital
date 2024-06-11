package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Dispensa;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DispensaService {
    public List<Dispensa> listar();

    public Dispensa atualizar(Dispensa dispensa, Long id);

    public boolean deletar(Long id);

    public Dispensa criar(Dispensa dispensa);

}
