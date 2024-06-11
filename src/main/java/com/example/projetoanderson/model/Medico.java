package com.example.projetoanderson.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MEDICO")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    @Column(name = "NOME")
    String nome;

    @Column(name = "SENHA")
    String senha;

    @Column(name = "CRM")
    String crm;

    @OneToMany(mappedBy = "medico")
    private List<Receita> receitas;

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
