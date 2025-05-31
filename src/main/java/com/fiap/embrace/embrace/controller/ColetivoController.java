package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.ColetivoDTO;
import com.fiap.embrace.embrace.entities.Coletivo;
import com.fiap.embrace.embrace.service.ColetivoService;
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

@Tag(name = "Coletivos", description = "Operações de CRUD para Coletivos")
@RestController
@RequestMapping("/coletivos")
public class ColetivoController {

    @Autowired
    private ColetivoService service;

    @Operation(
            summary = "Cria um novo Coletivo",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = ColetivoDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Coletivo criado com sucesso",
                            content = @Content(schema = @Schema(implementation = ColetivoDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    public ResponseEntity<ColetivoDTO> criar(@RequestBody @Valid ColetivoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @Operation(
            summary = "Lista Coletivos (com paginação, ordenação e filtro por nome)",
            description = "Use `nome` para filtrar pelo nome (OU parte do nome). " +
                    "Para controlar página e tamanho, envie `page`, `size` e `sort`.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Página de Coletivos",
                            content = @Content(schema = @Schema(implementation = ColetivoDTO.class, type = "array"))
                    )
            }
    )
    @GetMapping
    public ResponseEntity<Page<ColetivoDTO>> listar(
            @RequestParam(value = "nome", required = false) String nome,
            Pageable pageable
    ) {
        return ResponseEntity.ok(service.listar(nome, pageable));
    }

    @Operation(
            summary = "Busca um Coletivo por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Coletivo encontrado",
                            content = @Content(schema = @Schema(implementation = ColetivoDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Coletivo não encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ColetivoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(
            summary = "Atualiza um Coletivo existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = ColetivoDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Coletivo atualizado",
                            content = @Content(schema = @Schema(implementation = ColetivoDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Coletivo não encontrado"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ColetivoDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ColetivoDTO dto
    ) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(
            summary = "Exclui um Coletivo por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Coletivo excluído"),
                    @ApiResponse(responseCode = "404", description = "Coletivo não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
