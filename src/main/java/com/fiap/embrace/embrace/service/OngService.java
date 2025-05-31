package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.OngDTO;
import com.fiap.embrace.embrace.entities.Ong;
import com.fiap.embrace.embrace.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OngService {

    @Autowired
    private OngRepository repository;

    public Page<OngDTO> listar(String nome, String cnpj, Pageable pageable) {
        Page<Ong> page;

        boolean temNome = (nome != null && !nome.isBlank());
        boolean temCnpj = (cnpj != null && !cnpj.isBlank());

        if (temNome && temCnpj) {
            page = repository.findByNomeContainingIgnoreCaseAndCnpjContainingIgnoreCase(
                    nome, cnpj, pageable
            );
        }
        else if (temNome) {
            page = repository.findByNomeContainingIgnoreCase(nome, pageable);
        }
        else if (temCnpj) {
            page = repository.findByCnpjContainingIgnoreCase(cnpj, pageable);
        }
        else {
            page = repository.findAll(pageable);
        }

        return page.map(ong -> new OngDTO(
                ong.getId(),
                ong.getNome(),
                ong.getEmail(),
                ong.getSenha(),
                ong.getTelefone(),
                ong.getCnpj()
        ));
    }

    public Ong cadastrarOng(OngDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado para outra ONG.");
        }
        if (repository.existsByCnpj(dto.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado para outra ONG.");
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

    public Ong buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ONG não encontrada."));
    }

    public Ong atualizar(Long id, OngDTO dto) {
        Ong ong = buscarPorId(id);

        if (!ong.getEmail().equals(dto.getEmail())
                && repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado para outra ONG.");
        }
        if (!ong.getCnpj().equals(dto.getCnpj())
                && repository.existsByCnpj(dto.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado para outra ONG.");
        }

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
