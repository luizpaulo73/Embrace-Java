package com.fiap.embrace.embrace.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String item;

    @Min(1)
    private int quantidade;

    @ManyToOne
    private Campanha campanha;

    @ManyToOne
    private Voluntario doador;

    private String status;

    public Doacao() {
    }

    public Doacao(Long id, String item, int quantidade, Campanha campanha, Voluntario doador, String status) {
        this.id = id;
        this.item = item;
        this.quantidade = quantidade;
        this.campanha = campanha;
        this.doador = doador;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public Voluntario getDoador() {
        return doador;
    }

    public void setDoador(Voluntario doador) {
        this.doador = doador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
