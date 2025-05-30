package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.OngDTO;
import com.fiap.embrace.embrace.entities.Ong;
import com.fiap.embrace.embrace.service.OngService;
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

@Tag(name = "ONGs", description = "Operações de CRUD para ONGs")
@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    private OngService service;

    @Operation(
            summary = "Cadastra uma nova ONG",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = OngDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "ONG cadastrada com sucesso",
                            content = @Content(schema = @Schema(implementation = Ong.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping("/cadastrar")
    public ResponseEntity<Ong> cadastrar(
            @org.springframework.web.bind.annotation.RequestBody @Valid OngDTO dto
    ) {
        Ong novaOng = service.cadastrarOng(dto);
        return ResponseEntity.ok(novaOng);
    }

    @Operation(
            summary = "Lista todas as ONGs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de ONGs",
                            content = @Content(schema = @Schema(implementation = Ong.class, type = "array"))
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<Ong>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @Operation(
            summary = "Busca uma ONG por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "ONG encontrada",
                            content = @Content(schema = @Schema(implementation = Ong.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "ONG não encontrada")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Ong> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(
            summary = "Atualiza uma ONG existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = OngDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "ONG atualizada",
                            content = @Content(schema = @Schema(implementation = Ong.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "ONG não encontrada"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Ong> atualizar(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody @Valid OngDTO dto
    ) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(
            summary = "Exclui uma ONG por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "ONG excluída"),
                    @ApiResponse(responseCode = "404", description = "ONG não encontrada")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
