package com.example.projetoanderson.repository;

import com.example.projetoanderson.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsById(Long id);

    void deleteById(Long id);
}
