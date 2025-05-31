package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.AnuncioDTO;
import com.fiap.embrace.embrace.dto.DoadorInfoDTO;
import com.fiap.embrace.embrace.dto.OfertaDTO;
import com.fiap.embrace.embrace.dto.OfertaResponseDTO;
import com.fiap.embrace.embrace.entities.AnuncioMarketplace;
import com.fiap.embrace.embrace.entities.Oferta;
import com.fiap.embrace.embrace.entities.Usuario;
import com.fiap.embrace.embrace.entities.TipoEvento;
import com.fiap.embrace.embrace.repository.AnuncioRepository;
import com.fiap.embrace.embrace.repository.OfertaRepository;
import com.fiap.embrace.embrace.repository.UsuarioRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private OfertaRepository ofertaRepo;

    public AnuncioDTO criar(AnuncioDTO dto) {
        Usuario autor = usuarioRepo.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        AnuncioMarketplace a = new AnuncioMarketplace();
        a.setTitulo(dto.getTitulo());
        a.setDescricao(dto.getDescricao());
        a.setCep(dto.getCep());
        a.setLogradouro(dto.getLogradouro());
        a.setBairro(dto.getBairro());
        a.setCidadeEstado(dto.getCidadeEstado());
        a.setTipoEvento(dto.getTipoEvento());
        a.setTipoRecurso(dto.getTipoRecurso());
        a.setAutor(autor);
        a.setDataInicio(LocalDateTime.now());
        a.setDataFim(dto.getDataFim());
        a.setAtivo(true);

        a = repo.save(a);
        return toDto(a);
    }

    public Page<AnuncioDTO> listarPaginado(
            String tipoEventoString,
            String cidadeEstado,
            Pageable pageable
    ) {
        Specification<AnuncioMarketplace> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.isTrue(root.get("ativo")));

            if (tipoEventoString != null && !tipoEventoString.isBlank()) {
                try {
                    TipoEvento tipoEvento = TipoEvento.valueOf(tipoEventoString.toUpperCase());
                    predicates.add(cb.equal(root.get("tipoEvento"), tipoEvento));
                } catch (IllegalArgumentException ex) {
                    throw new RuntimeException("Tipo de evento inválido: " + tipoEventoString);
                }
            }

            if (cidadeEstado != null && !cidadeEstado.isBlank()) {
                predicates.add(cb.like(
                        cb.lower(root.get("cidadeEstado")),
                        "%" + cidadeEstado.toLowerCase() + "%"
                ));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<AnuncioMarketplace> pageEntidade = repo.findAll(spec, pageable);

        return pageEntidade.map(this::toDto);
    }

    @Transactional
    public OfertaResponseDTO ofertar(OfertaDTO dto) {
        AnuncioMarketplace a = repo.findById(dto.getAnuncioId())
                .orElseThrow(() -> new RuntimeException("Anúncio não encontrado"));

        int novoTotal = a.getTotalOfertado() + dto.getQuantidade();
        a.setTotalOfertado(novoTotal);
        repo.save(a);

        Oferta oferta = new Oferta();
        oferta.setAnuncio(a);
        Usuario voluntario = usuarioRepo.findById(dto.getVoluntarioId())
                .orElseThrow(() -> new RuntimeException("Voluntário não encontrado"));
        oferta.setDoador((com.fiap.embrace.embrace.entities.Voluntario) voluntario);
        oferta.setQuantidade(dto.getQuantidade());
        oferta.setDataOferta(LocalDateTime.now());
        ofertaRepo.save(oferta);

        String mensagem = "Total ofertado: " + novoTotal;
        return new OfertaResponseDTO(a.getId(), novoTotal, Math.max(novoTotal, 0), mensagem);
    }

    public OfertaResponseDTO getOferta(Long anuncioId) {
        AnuncioMarketplace a = repo.findById(anuncioId)
                .orElseThrow(() -> new RuntimeException("Anúncio não encontrado"));

        int total = a.getTotalOfertado();
        String mensagem = "Total ofertado: " + total;
        return new OfertaResponseDTO(a.getId(), total, Math.max(total, 0), mensagem);
    }

    private AnuncioDTO toDto(AnuncioMarketplace a) {
        return new AnuncioDTO(
                a.getId(),
                a.getTitulo(),
                a.getDescricao(),
                a.getCep(),
                a.getLogradouro(),
                a.getBairro(),
                a.getCidadeEstado(),
                a.getTipoEvento(),
                a.getTipoRecurso(),
                a.getDataInicio(),
                a.getDataFim(),
                a.isAtivo(),
                a.getTotalOfertado(),
                a.getAutor().getId()
        );
    }

    public List<DoadorInfoDTO> listarDoadores(Long anuncioId) {
        List<Oferta> ofertas = ofertaRepo.findByAnuncioId(anuncioId);

        return ofertas.stream()
                .map(of -> {
                    com.fiap.embrace.embrace.entities.Voluntario v = of.getDoador();
                    return new DoadorInfoDTO(
                            v.getNome(),
                            v.getEmail(),
                            v.getTelefone(),
                            of.getQuantidade()
                    );
                })
                .distinct()
                .collect(Collectors.toList());
    }
}
