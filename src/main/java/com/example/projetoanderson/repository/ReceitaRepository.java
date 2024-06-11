package com.example.projetoanderson.repository;

import com.example.projetoanderson.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    boolean existsById(Long id);

    void deleteById(Long id);
}
