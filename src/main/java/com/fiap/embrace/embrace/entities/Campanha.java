package com.fiap.embrace.embrace.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String local;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @ManyToOne
    private Usuario criador;

    private int metaDoacoes;
    private int doacoesRecebidas;

    @OneToMany(mappedBy = "campanha", cascade = CascadeType.ALL)
    private List<Doacao> doacoes = new ArrayList<>();

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private boolean ativo = true; // inicio e fim da campanha


    public Campanha() {
    }

    public Campanha(Long id, String nome, String descricao, String local, TipoEvento tipoEvento, Usuario criador, int metaDoacoes, int doacoesRecebidas, List<Doacao> doacoes, LocalDateTime dataInicio, LocalDateTime dataFim, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.tipoEvento = tipoEvento;
        this.criador = criador;
        this.metaDoacoes = metaDoacoes;
        this.doacoesRecebidas = doacoesRecebidas;
        this.doacoes = doacoes;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public int getMetaDoacoes() {
        return metaDoacoes;
    }

    public void setMetaDoacoes(int metaDoacoes) {
        this.metaDoacoes = metaDoacoes;
    }

    public int getDoacoesRecebidas() {
        return doacoesRecebidas;
    }

    public void setDoacoesRecebidas(int doacoesRecebidas) {
        this.doacoesRecebidas = doacoesRecebidas;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
