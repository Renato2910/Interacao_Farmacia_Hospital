package com.example.projetoanderson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DISPENSA")
public class Dispensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDispensa;

    @Column(name = "DATA_DISPENSA")
    String dataDispensa;

    @Column(name = "MEDICAMENTO_DISPENSADO")
    String medicamentosDispensados;

    @Column(name = "QUANTIDADE")
    int quantidadeDispensado;

    @Column (name = "RESPONSAVEL")
    String farmaceuticoResponsavel;

    public Long getIdDispensa() {
        return idDispensa;
    }

    public void setIdDispensa(Long idDispensa) {
        this.idDispensa = idDispensa;
    }

    public String getDataDispensa() {
        return dataDispensa;
    }

    public void setDataDispensa(String dataDispensa) {
        this.dataDispensa = dataDispensa;
    }

    public String getMedicamentosDispensados() {
        return medicamentosDispensados;
    }

    public void setMedicamentosDispensados(String medicamentosDispensados) {
        this.medicamentosDispensados = medicamentosDispensados;
    }

    public int getQuantidadeDispensado() {
        return quantidadeDispensado;
    }

    public void setQuantidadeDispensado(int quantidadeDispensado) {
        this.quantidadeDispensado = quantidadeDispensado;
    }

    public String getFarmaceuticoResponsavel() {
        return farmaceuticoResponsavel;
    }

    public void setFarmaceuticoResponsavel(String farmaceuticoResponsavel) {
        this.farmaceuticoResponsavel = farmaceuticoResponsavel;
    }
}
