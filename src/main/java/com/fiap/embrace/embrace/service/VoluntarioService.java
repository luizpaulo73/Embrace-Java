package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.VoluntarioDTO;
import com.fiap.embrace.embrace.entities.Voluntario;
import com.fiap.embrace.embrace.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository repository;

    public Voluntario cadastrarVoluntario(VoluntarioDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        Voluntario voluntario = new Voluntario(
                null,
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getTelefone(),
                "VOLUNTARIO"
        );

        return repository.save(voluntario);
    }

    public List<Voluntario> listarTodos() {
        return repository.findAll();
    }

    public Voluntario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Voluntário não encontrado."));
    }

    public Voluntario atualizar(Long id, VoluntarioDTO dto) {
        Voluntario voluntario = buscarPorId(id);
        voluntario.setNome(dto.getNome());
        voluntario.setEmail(dto.getEmail());
        voluntario.setSenha(dto.getSenha());
        voluntario.setTelefone(dto.getTelefone());
        return repository.save(voluntario);
    }

    public void deletar(Long id) {
        Voluntario voluntario = buscarPorId(id);
        repository.delete(voluntario);
    }
}