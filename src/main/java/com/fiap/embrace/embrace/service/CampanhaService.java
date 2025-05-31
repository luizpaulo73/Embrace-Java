package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.CampanhaDTO;
import com.fiap.embrace.embrace.dto.DoadorInfoDTO;
import com.fiap.embrace.embrace.entities.Campanha;
import com.fiap.embrace.embrace.entities.Doacao;
import com.fiap.embrace.embrace.entities.Usuario;
import com.fiap.embrace.embrace.entities.TipoEvento;
import com.fiap.embrace.embrace.repository.CampanhaRepository;
import com.fiap.embrace.embrace.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public CampanhaDTO criar(CampanhaDTO dto) {
        Usuario criador = usuarioRepo.findById(dto.getCriadorId())
                .orElseThrow(() -> new RuntimeException("Criador não encontrado"));

        if (dto.getDataFim().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("dataFim deve ser uma data futura");
        }

        Campanha c = new Campanha();
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        c.setCep(dto.getCep());
        c.setLogradouro(dto.getLogradouro());
        c.setBairro(dto.getBairro());
        c.setCidadeEstado(dto.getCidadeEstado());
        c.setTipoEvento(dto.getTipoEvento());
        c.setMetaDoacoes(dto.getMetaDoacoes());
        c.setDoacoesRecebidas(0);
        c.setCriador(criador);
        c.setDataInicio(LocalDateTime.now());
        c.setDataFim(dto.getDataFim());
        c.setAtivo(true);

        c = repo.save(c);
        return toDto(c);
    }

    public Page<CampanhaDTO> listarCampanhas(String cidadeEstado, TipoEvento tipoEvento, Pageable pageable) {
        Page<Campanha> page;

        boolean filtroCidade = (cidadeEstado != null && !cidadeEstado.isBlank());
        boolean filtroTipo   = (tipoEvento != null);

        if (filtroCidade && filtroTipo) {
            page = repo.findByAtivoTrueAndCidadeEstadoContainingIgnoreCaseAndTipoEvento(
                    cidadeEstado, tipoEvento, pageable
            );
        }
        else if (filtroCidade) {
            page = repo.findByAtivoTrueAndCidadeEstadoContainingIgnoreCase(cidadeEstado, pageable);
        }
        else if (filtroTipo) {
            page = repo.findByAtivoTrueAndTipoEvento(tipoEvento, pageable);
        }
        else {
            page = repo.findByAtivoTrue(pageable);
        }

        return page.map(this::toDto);
    }

    private CampanhaDTO toDto(Campanha c) {
        return new CampanhaDTO(
                c.getId(),
                c.getNome(),
                c.getDescricao(),
                c.getCep(),
                c.getLogradouro(),
                c.getBairro(),
                c.getCidadeEstado(),
                c.getTipoEvento(),
                c.getMetaDoacoes(),
                c.getDoacoesRecebidas(),
                c.getDataInicio(),
                c.getDataFim(),
                c.isAtivo(),
                c.getCriador().getId()
        );
    }

    public List<DoadorInfoDTO> listarDoadoresDaCampanha(Long campanhaId) {
        Campanha campanha = repo.findById(campanhaId)
                .orElseThrow(() -> new RuntimeException("Campanha não encontrada"));

        List<DoadorInfoDTO> doadores = new ArrayList<>();
        for (Doacao doacao : campanha.getDoacoes()) {
            Usuario voluntario = doacao.getDoador();
            DoadorInfoDTO dto = new DoadorInfoDTO(
                    voluntario.getNome(),
                    voluntario.getEmail(),
                    voluntario.getTelefone(),
                    doacao.getQuantidade()
            );
            doadores.add(dto);
        }
        return doadores.stream()
                .distinct()
                .collect(Collectors.toList());
    }

}
