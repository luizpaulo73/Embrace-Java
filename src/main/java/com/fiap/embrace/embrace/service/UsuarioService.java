package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.UsuarioDTO;
import com.fiap.embrace.embrace.entities.Usuario;
import com.fiap.embrace.embrace.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO login(String email, String senha) {
        Optional<Usuario> opt = repository.findByEmailAndSenha(email, senha);
        if (opt.isEmpty()) throw new RuntimeException("Usuário ou senha inválidos");

        Usuario user = opt.get();
        return new UsuarioDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getTelefone(),
                user.getTipo()
        );
    }
}
