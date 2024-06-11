package com.example.projetoanderson.repository;

import com.example.projetoanderson.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsById(Long id);

    void deleteById(Long id);
}
