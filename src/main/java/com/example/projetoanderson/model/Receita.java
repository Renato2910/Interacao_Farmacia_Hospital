package com.example.projetoanderson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RECEITA")

public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PACIENTE")
    String paciente;

    @Column(name = "MEDICO")
    String medico;

    @Column(name = "MEDICAMENTO")
    String medicamentos;

    @Column(name = "DATA_HORA_ENVIO")
    String dataHoraEnvio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(String dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }
}
