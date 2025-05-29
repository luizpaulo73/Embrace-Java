package com.fiap.embrace.embrace.entities;

import jakarta.persistence.Entity;

@Entity
public class Ong extends Usuario{

    private String cnpj;

    public Ong() {
    }

    public Ong(String cnpj) {
        this.cnpj = cnpj;
    }

    public Ong(Long id, String nome, String email, String senha, String telefone, String tipo, String cnpj) {
        super(id, nome, email, senha, telefone, tipo);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Ong{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }


}
