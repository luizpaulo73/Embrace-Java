package com.fiap.embrace.embrace.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "voluntarios")
public class Voluntario extends Usuario{

    public Voluntario() {
        super();
    }

    public Voluntario(Long id, String nome, String email, String senha, String telefone, String tipo) {
        super(id, nome, email, senha, telefone, tipo);
    }
}
