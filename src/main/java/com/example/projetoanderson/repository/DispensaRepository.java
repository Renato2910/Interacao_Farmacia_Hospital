package com.example.projetoanderson.repository;

import com.example.projetoanderson.model.Dispensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispensaRepository extends JpaRepository<Dispensa, Long> {
    boolean existsById(Long id);

    void deleteById(Long id);
}
