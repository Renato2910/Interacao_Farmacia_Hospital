package com.example.projetoanderson.repository;

import com.example.projetoanderson.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    boolean existsById(Long id);

    void deleteById(Long id);
}
