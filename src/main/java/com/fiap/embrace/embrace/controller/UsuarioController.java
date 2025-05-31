package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.UsuarioDTO;
import com.fiap.embrace.embrace.dto.UsuarioLoginDTO;
import com.fiap.embrace.embrace.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuários", description = "Operações de autenticação de usuário")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Operation(
            summary = "Realiza login de usuário",
            description = "Autentica um usuário com email e senha e retorna seus dados básicos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = UsuarioLoginDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login efetuado com sucesso",
                            content = @Content(schema = @Schema(implementation = UsuarioDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                    @ApiResponse(responseCode = "401", description = "Email ou senha incorretos")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(
            @RequestBody @Valid UsuarioLoginDTO loginDto
    ) {
        UsuarioDTO usuario = service.login(loginDto.getEmail(), loginDto.getSenha());
        return ResponseEntity.ok(usuario);
    }
}
