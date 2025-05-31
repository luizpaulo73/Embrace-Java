package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.DoacaoDTO;
import com.fiap.embrace.embrace.dto.DoacaoResponseDTO;
import com.fiap.embrace.embrace.service.DoacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Doações", description = "Doação de itens para campanhas")
@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired private DoacaoService service;

    @Operation(summary = "Realiza doação para campanha",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = DoacaoDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Doação registrada com sucesso",
                            content = @Content(schema = @Schema(implementation = DoacaoResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    @PostMapping
    public ResponseEntity<DoacaoResponseDTO> doar(@RequestBody @Valid DoacaoDTO dto) {
        DoacaoResponseDTO resp = service.doar(dto);
        return ResponseEntity.ok(resp);
    }
}
