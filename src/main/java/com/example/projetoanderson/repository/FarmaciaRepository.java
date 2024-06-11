package com.example.projetoanderson.repository;

import com.example.projetoanderson.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
    boolean existsById(Long id);

    void deleteById(Long id);
}
