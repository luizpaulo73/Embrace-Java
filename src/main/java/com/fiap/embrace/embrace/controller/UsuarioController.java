package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.UsuarioDTO;
import com.fiap.embrace.embrace.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String senha = loginRequest.get("senha");
        return ResponseEntity.ok(service.login(email, senha));
    }
}
