package com.fiap.embrace.embrace.entities;

import jakarta.persistence.Entity;

@Entity
public class Coletivo extends Usuario {

    private String representante;

    public Coletivo() {
    }

    public Coletivo(String representante) {
        this.representante = representante;
    }

    public Coletivo(Long id, String nome, String email, String senha, String telefone, String tipo, String representante) {
        super(id, nome, email, senha, telefone, tipo);
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "Coletivo{" +
                "representante='" + representante + '\'' +
                '}';
    }
}
