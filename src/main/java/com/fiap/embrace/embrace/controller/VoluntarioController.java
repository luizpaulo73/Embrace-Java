package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.VoluntarioDTO;
import com.fiap.embrace.embrace.entities.Voluntario;
import com.fiap.embrace.embrace.service.VoluntarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Voluntários", description = "Operações de CRUD para Voluntários")
@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService service;

    @Operation(
            summary = "Cadastra um novo voluntário",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Voluntário cadastrado com sucesso",
                            content = @Content(schema = @Schema(implementation = Voluntario.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping("/cadastrar")
    public ResponseEntity<Voluntario> cadastrar(
            @org.springframework.web.bind.annotation.RequestBody @Valid VoluntarioDTO dto
    ) {
        Voluntario novo = service.cadastrarVoluntario(dto);
        return ResponseEntity.ok(novo);
    }

    @Operation(
            summary = "Lista todos os voluntários",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de voluntários",
                            content = @Content(schema = @Schema(implementation = Voluntario.class, type = "array"))
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<Voluntario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(
            summary = "Busca um voluntário por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Voluntário encontrado",
                            content = @Content(schema = @Schema(implementation = Voluntario.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Voluntário não encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(
            summary = "Atualiza um voluntário existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Voluntário atualizado",
                            content = @Content(schema = @Schema(implementation = Voluntario.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Voluntário não encontrado"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> atualizar(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody @Valid VoluntarioDTO dto
    ) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(
            summary = "Exclui um voluntário por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Voluntário excluído"),
                    @ApiResponse(responseCode = "404", description = "Voluntário não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
