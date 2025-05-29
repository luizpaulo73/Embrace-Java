package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.ColetivoDTO;
import com.fiap.embrace.embrace.entities.Coletivo;
import com.fiap.embrace.embrace.service.ColetivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coletivos")
public class ColetivoController {

    @Autowired
    private ColetivoService service;

    @PostMapping
    public ResponseEntity<ColetivoDTO> criar(@RequestBody @Valid ColetivoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Coletivo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColetivoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ColetivoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ColetivoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }
}