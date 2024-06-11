package com.example.projetoanderson.controller;

import com.example.projetoanderson.model.Assinatura;
import com.example.projetoanderson.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/assinatura")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    @PostMapping("/salvar")
    public ResponseEntity<Assinatura> salvarAssinatura(@RequestParam("farmacia") String farmacia, @RequestParam("arquivo") MultipartFile arquivo) throws IOException {
        Assinatura assinatura = new Assinatura();
        assinatura.setFarmacia(farmacia);
        assinatura.setAssinaturaDigital(arquivo.getBytes());
        Assinatura novaAssinatura = assinaturaService.salvar(assinatura);
        return new ResponseEntity<>(novaAssinatura, HttpStatus.CREATED);
    }
}
