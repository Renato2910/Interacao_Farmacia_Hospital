package com.example.projetoanderson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FARMACIA")

public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFarmacia;

    @Column(name = "CNPJ")
    String cnpj;

    @Column(name = "SENHA")
    String senha;

    public Long getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Long idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
