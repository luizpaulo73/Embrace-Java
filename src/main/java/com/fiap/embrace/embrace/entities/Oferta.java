package com.fiap.embrace.embrace.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Voluntario doador;

    @ManyToOne
    private AnuncioMarketplace anuncio;

    private int quantidade;
    private LocalDateTime dataOferta;

    public Oferta() {}

    public Oferta(Long id, Voluntario doador, AnuncioMarketplace anuncio, int quantidade, LocalDateTime dataOferta) {
        this.id = id;
        this.doador = doador;
        this.anuncio = anuncio;
        this.quantidade = quantidade;
        this.dataOferta = dataOferta;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Voluntario getDoador() {
        return doador;
    }
    public void setDoador(Voluntario doador) {
        this.doador = doador;
    }

    public AnuncioMarketplace getAnuncio() {
        return anuncio;
    }
    public void setAnuncio(AnuncioMarketplace anuncio) {
        this.anuncio = anuncio;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataOferta() {
        return dataOferta;
    }
    public void setDataOferta(LocalDateTime dataOferta) {
        this.dataOferta = dataOferta;
    }
}
