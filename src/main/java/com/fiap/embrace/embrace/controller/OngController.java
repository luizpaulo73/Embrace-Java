package com.fiap.embrace.embrace.controller;

import com.fiap.embrace.embrace.dto.OngDTO;
import com.fiap.embrace.embrace.entities.Ong;
import com.fiap.embrace.embrace.service.OngService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    private OngService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Ong> cadastrar(@RequestBody @Valid OngDTO dto) {
        Ong novaOng = service.cadastrarOng(dto);
        return ResponseEntity.ok(novaOng);
    }

    @GetMapping
    public ResponseEntity<List<Ong>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ong> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ong> atualizar(@PathVariable Long id,
                                         @RequestBody @Valid OngDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}