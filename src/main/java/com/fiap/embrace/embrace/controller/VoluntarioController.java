package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.VoluntarioDTO;
import com.fiap.embrace.embrace.entities.Voluntario;
import com.fiap.embrace.embrace.service.VoluntarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Voluntario> cadastrar(@RequestBody @Valid VoluntarioDTO dto) {
        Voluntario novoVoluntario = service.cadastrarVoluntario(dto);
        return ResponseEntity.ok(novoVoluntario);
    }

    @GetMapping
    public ResponseEntity<List<Voluntario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> atualizar(@PathVariable Long id,
                                                @RequestBody @Valid VoluntarioDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}