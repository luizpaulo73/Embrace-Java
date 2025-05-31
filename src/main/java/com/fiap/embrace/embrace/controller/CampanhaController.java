package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.CampanhaDTO;
import com.fiap.embrace.embrace.dto.DoadorInfoDTO;
import com.fiap.embrace.embrace.entities.TipoEvento;
import com.fiap.embrace.embrace.service.CampanhaService;
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

import java.util.List;

@Tag(name = "Campanhas", description = "Feed e cadastro de campanhas")
@RestController
@RequestMapping("/campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaService service;

    @Operation(
            summary = "Cria nova campanha",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = CampanhaDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Campanha criada",
                            content = @Content(schema = @Schema(implementation = CampanhaDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    public ResponseEntity<CampanhaDTO> criar(@RequestBody @Valid CampanhaDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @Operation(
            summary = "Lista campanhas ativas (com paginação, ordenação e filtros)",
            description = "Você pode filtrar por cidadeEstado e/ou tipoEvento. Use parâmetros `page`, `size` e `sort` para controle de paginação e ordenação.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Página de campanhas",
                            content = @Content(schema = @Schema(implementation = CampanhaDTO.class, type = "array"))
                    )
            }
    )
    @GetMapping
    public ResponseEntity<Page<CampanhaDTO>> listar(
            @RequestParam(value = "cidadeEstado", required = false) String cidadeEstado,
            @RequestParam(value = "tipoEvento",   required = false) TipoEvento tipoEvento,
            Pageable pageable
    ) {
        Page<CampanhaDTO> page = service.listarCampanhas(cidadeEstado, tipoEvento, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Lista os doadores de uma campanha")
    @GetMapping("/{id}/doadores")
    public ResponseEntity<List<DoadorInfoDTO>> listarDoadores(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarDoadoresDaCampanha(id));
    }
}
