package com.example.projetoanderson.service;

import com.example.projetoanderson.model.Assinatura;
import com.example.projetoanderson.repository.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public Assinatura salvar(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }
}
