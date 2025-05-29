package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.OngDTO;
import com.fiap.embrace.embrace.entities.Ong;
import com.fiap.embrace.embrace.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngService {

    @Autowired
    private OngRepository repository;

    public Ong cadastrarOng(OngDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        if (repository.existsByCnpj(dto.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        }

        Ong ong = new Ong(
                null,
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getTelefone(),
                "ONG",
                dto.getCnpj()
        );

        return repository.save(ong);
    }

    public List<Ong> listarTodas() {
        return repository.findAll();
    }

    public Ong buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ONG não encontrada."));
    }

    public Ong atualizar(Long id, OngDTO dto) {
        Ong ong = buscarPorId(id);
        ong.setNome(dto.getNome());
        ong.setEmail(dto.getEmail());
        ong.setSenha(dto.getSenha());
        ong.setTelefone(dto.getTelefone());
        ong.setCnpj(dto.getCnpj());
        return repository.save(ong);
    }

    public void deletar(Long id) {
        Ong ong = buscarPorId(id);
        repository.delete(ong);
    }
}
