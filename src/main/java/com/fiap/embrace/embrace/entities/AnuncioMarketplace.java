package com.fiap.embrace.embrace.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class AnuncioMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String local;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @NotBlank
    private String tipoRecurso;

    private boolean ativo = true;

    @ManyToOne
    private Usuario autor;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    public AnuncioMarketplace() {
    }

    public AnuncioMarketplace(Long id, String titulo, String descricao, String local, TipoEvento tipoEvento,
                              String tipoRecurso, boolean ativo, Usuario autor,
                              LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.tipoEvento = tipoEvento;
        this.tipoRecurso = tipoRecurso;
        this.ativo = ativo;
        this.autor = autor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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
}
