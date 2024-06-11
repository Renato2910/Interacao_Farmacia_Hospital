package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Medicamento;
import com.example.projetoanderson.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class MedicamentoServiceConcrete implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> listarMedicamento() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Medicamento atualizar(Medicamento medicamento, Long id) {
        if (medicamentoRepository.existsById(id)) {
            medicamento.setIdMedicamento(id);
            return medicamentoRepository.save(medicamento);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if (id <= 0) {
            return false;
        }
        if (!medicamentoRepository.existsById(id)) {
            return false;
        }
        medicamentoRepository.deleteById(id);
        return true;
    }

    @Override
    public Medicamento criar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }
}
