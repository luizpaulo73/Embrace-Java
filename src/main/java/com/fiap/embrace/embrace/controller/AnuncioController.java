package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.AnuncioDTO;
import com.fiap.embrace.embrace.dto.DoadorInfoDTO;
import com.fiap.embrace.embrace.dto.OfertaDTO;
import com.fiap.embrace.embrace.dto.OfertaResponseDTO;
import com.fiap.embrace.embrace.service.AnuncioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Tag(name = "Marketplace", description = "CRUD e ofertas no Marketplace")
@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioService service;

    @Operation(summary = "Cria anúncio")
    @PostMapping
    public ResponseEntity<AnuncioDTO> criar(@RequestBody @Valid AnuncioDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @Operation(
            summary = "Lista anúncios ativos com paginação, ordenação e filtros",
            description = """
            Os parâmetros de consulta aceitos são:
            - tipoEvento (opcional; ex.: FRIO, ENCHENTE)
            - cidadeEstado (opcional; qualquer parte do nome da cidade/estado, case‐insensitive)
            - page (inteiro ≥ 0, default = 0)
            - size (inteiro > 0, default = 20)
            - sort (campo, direção); ex.: sort=dataFim,desc
            """)
    @GetMapping
    public ResponseEntity<Page<AnuncioDTO>> listar(
            @RequestParam(required = false) String tipoEvento,
            @RequestParam(required = false) String cidadeEstado,
            Pageable pageable
    ) {
        Page<AnuncioDTO> page = service.listarPaginado(tipoEvento, cidadeEstado, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Ofertar recurso em anúncio")
    @PostMapping("/oferta")
    public ResponseEntity<OfertaResponseDTO> ofertar(@RequestBody @Valid OfertaDTO dto) {
        return ResponseEntity.ok(service.ofertar(dto));
    }

    @Operation(summary = "Consulta status de ofertas de um anúncio")
    @GetMapping("/{id}/oferta")
    public ResponseEntity<OfertaResponseDTO> getOferta(@PathVariable("id") Long anuncioId) {
        return ResponseEntity.ok(service.getOferta(anuncioId));
    }

    @Operation(summary = "Lista doadores de um anúncio (nome, e-mail, telefone e quantidade)")
    @GetMapping("/{id}/doadores")
    public ResponseEntity<List<DoadorInfoDTO>> listarDoadores(@PathVariable("id") Long anuncioId) {
        return ResponseEntity.ok(service.listarDoadores(anuncioId));
    }
}
