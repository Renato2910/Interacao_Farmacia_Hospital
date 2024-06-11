package com.example.projetoanderson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    @Column(name = "NOME")
    String nome;

    @Column(name = "DOSAGEM")
    Float dosagem;

    @Column(name = "QUANTIDADE")
    int quantidade;

    @Column(name = "VIA_ADMINISTRACAO")
    String viaAdministracao;

    @Column(name = "OBSERVACAO")
    String observacao;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDosagem() {
        return dosagem;
    }

    public void setDosagem(Float dosagem) {
        this.dosagem = dosagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(String viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }
}
