package com.example.projetoanderson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ASSINATURA")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FARMACIA")
    private String farmacia;

    @Lob
    @Column(name = "ASSINATURA_DIGITAL")
    private byte[] assinaturaDigital;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public byte[] getAssinaturaDigital() {
        return assinaturaDigital;
    }

    public void setAssinaturaDigital(byte[] assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }
}
