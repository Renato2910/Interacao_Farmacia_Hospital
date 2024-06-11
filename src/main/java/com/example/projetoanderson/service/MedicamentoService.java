package com.example.projetoanderson.service;
import com.example.projetoanderson.model.Medicamento;
import com.example.projetoanderson.model.Paciente;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public interface MedicamentoService {
    public List<Medicamento> listarMedicamento();

    public Medicamento atualizar(Medicamento medicamento, Long id);

    public boolean deletar(Long id);

    public Medicamento criar(Medicamento medicamento);
}
