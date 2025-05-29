package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.ColetivoDTO;
import com.fiap.embrace.embrace.entities.Coletivo;
import com.fiap.embrace.embrace.repository.ColetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColetivoService {

    @Autowired
    private ColetivoRepository repository;

    public ColetivoDTO salvar(ColetivoDTO dto) {
        Coletivo coletivo = new Coletivo(
                null,
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getTelefone(),
                "COLETIVO",
                dto.getRepresentante()
        );
        coletivo = repository.save(coletivo);
        return new ColetivoDTO(
                coletivo.getId(),
                coletivo.getNome(),
                coletivo.getEmail(),
                coletivo.getSenha(),
                coletivo.getTelefone(),
                coletivo.getRepresentante()
        );
    }

    public List<Coletivo> listarTodos() {
        return repository.findAll();
    }

    public ColetivoDTO buscarPorId(Long id) {
        Optional<Coletivo> opt = repository.findById(id);
        if (opt.isEmpty()) throw new RuntimeException("Coletivo não encontrado");
        Coletivo c = opt.get();
        return new ColetivoDTO(
                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getSenha(),
                c.getTelefone(),
                c.getRepresentante()
        );
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) throw new RuntimeException("ID não encontrado");
        repository.deleteById(id);
    }
    public ColetivoDTO atualizar(Long id, ColetivoDTO dto) {
        Optional<Coletivo> opt = repository.findById(id);
        if (opt.isEmpty()) throw new RuntimeException("Coletivo não encontrado");

        Coletivo existente = opt.get();
        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setSenha(dto.getSenha());
        existente.setTelefone(dto.getTelefone());
        existente.setRepresentante(dto.getRepresentante());

        Coletivo atualizado = repository.save(existente);
        return new ColetivoDTO(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getSenha(),
                atualizado.getTelefone(),
                atualizado.getRepresentante()
        );
    }
}

