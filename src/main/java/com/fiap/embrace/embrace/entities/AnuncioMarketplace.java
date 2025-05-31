package com.fiap.embrace.embrace.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
@Entity
public class AnuncioMarketplace {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String titulo;
    @NotBlank private String descricao;

    @NotBlank private String cep;
    @NotBlank private String logradouro;
    @NotBlank private String bairro;
    @NotBlank private String cidadeEstado;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @NotBlank private String tipoRecurso;

    private boolean ativo = true;

    @ManyToOne
    private Usuario autor;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private int totalOfertado = 0;

    public AnuncioMarketplace() {}

    public AnuncioMarketplace(Long id, String titulo, String descricao, String cep, String logradouro, String bairro, String cidadeEstado, TipoEvento tipoEvento, String tipoRecurso, boolean ativo, Usuario autor, LocalDateTime dataInicio, LocalDateTime dataFim, int totalOfertado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidadeEstado = cidadeEstado;
        this.tipoEvento = tipoEvento;
        this.tipoRecurso = tipoRecurso;
        this.ativo = ativo;
        this.autor = autor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.totalOfertado = totalOfertado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidadeEstado() {
        return cidadeEstado;
    }

    public void setCidadeEstado(String cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public int getTotalOfertado() {
        return totalOfertado;
    }

    public void setTotalOfertado(int totalOfertado) {
        this.totalOfertado = totalOfertado;
    }
}
