package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Dispensa;
import com.example.projetoanderson.repository.DispensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DispensaServiceConcrete implements DispensaService {

    @Autowired
    private DispensaRepository dispensaRepository;

    @Override
    public List<Dispensa> listar() {
        return dispensaRepository.findAll();
    }

    @Override
    public Dispensa atualizar(Dispensa dispensa, Long id) {
        if (dispensaRepository.existsById(id)) {
            dispensa.setIdDispensa(id);
            return dispensaRepository.save(dispensa);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (id <= 0) {
            return false;
        }
        if (!dispensaRepository.existsById(id)) {
            return false;
        }
        dispensaRepository.deleteById(id);
        return true;
    }

    @Override
    public Dispensa criar(Dispensa dispensa) {
        return dispensaRepository.save(dispensa);
    }
}
