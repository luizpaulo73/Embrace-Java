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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Voluntários", description = "Operações de CRUD para Voluntários")
@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService service;

    @Operation(
            summary = "Cadastra um novo Voluntário",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Voluntário cadastrado com sucesso",
                            content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping("/cadastrar")
    public ResponseEntity<Voluntario> cadastrar(@RequestBody @Valid VoluntarioDTO dto) {
        Voluntario novo = service.cadastrarVoluntario(dto);
        return ResponseEntity.ok(novo);
    }

    @Operation(
            summary = "Lista Voluntários (com paginação, ordenação e filtro por nome)",
            description = "Use `nome` para filtrar por parte do nome. " +
                    "Para controlar página, tamanho e ordenação, envie `page`, `size` e `sort`.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Página de Voluntários",
                            content = @Content(schema = @Schema(implementation = VoluntarioDTO.class, type = "array"))
                    )
            }
    )
    @GetMapping
    public ResponseEntity<Page<VoluntarioDTO>> listar(
            @RequestParam(value = "nome", required = false) String nome,
            Pageable pageable
    ) {
        return ResponseEntity.ok(service.listar(nome, pageable));
    }

    @Operation(
            summary = "Busca um Voluntário por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Voluntário encontrado",
                            content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Voluntário não encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioDTO> buscarPorId(@PathVariable Long id) {
        Voluntario v = service.buscarPorId(id);
        VoluntarioDTO dto = new VoluntarioDTO(
                v.getNome(),
                v.getEmail(),
                v.getSenha(),
                v.getTelefone()
        );
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Atualiza um Voluntário existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Voluntário atualizado",
                            content = @Content(schema = @Schema(implementation = VoluntarioDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Voluntário não encontrado"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<VoluntarioDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid VoluntarioDTO dto
    ) {
        Voluntario atualizado = service.atualizar(id, dto);
        VoluntarioDTO saida = new VoluntarioDTO(
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getSenha(),
                atualizado.getTelefone()
        );
        return ResponseEntity.ok(saida);
    }

    @Operation(
            summary = "Exclui um Voluntário por ID",
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
