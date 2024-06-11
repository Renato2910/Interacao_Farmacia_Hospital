package com.example.projetoanderson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(name = "NOME_PACIENTE")
    String nome;

    @Column(name = "DATA_NASCIMENTO")
    String dataNascimento;

    @Column(name = "CPF")
    String cpf;

    @Column(name = "PLANOSAUDE")
    Boolean planosaude;

    public String getNome() {
        return nome;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getPlanosaude() {
        return planosaude;
    }

    public void setPlanosaude(Boolean planosaude) {
        this.planosaude = planosaude;
    }
}
