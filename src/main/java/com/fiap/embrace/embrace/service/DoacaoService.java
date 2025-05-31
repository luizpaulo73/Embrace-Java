package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.dto.DoacaoDTO;
import com.fiap.embrace.embrace.dto.DoacaoResponseDTO;
import com.fiap.embrace.embrace.entities.Campanha;
import com.fiap.embrace.embrace.entities.Doacao;
import com.fiap.embrace.embrace.entities.Voluntario;
import com.fiap.embrace.embrace.repository.CampanhaRepository;
import com.fiap.embrace.embrace.repository.DoacaoRepository;
import com.fiap.embrace.embrace.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoacaoService {

    @Autowired private DoacaoRepository doacaoRepo;
    @Autowired private CampanhaRepository campanhaRepo;
    @Autowired private VoluntarioRepository voluntarioRepo;

    @Transactional
    public DoacaoResponseDTO doar(DoacaoDTO dto) {
        Campanha c = campanhaRepo.findById(dto.getCampanhaId())
                .orElseThrow(() -> new RuntimeException("Campanha não encontrada"));

        Voluntario v = voluntarioRepo.findById(dto.getVoluntarioId())
                .orElseThrow(() -> new RuntimeException("Voluntário não encontrado"));

        if (!c.isAtivo()) throw new IllegalStateException("Campanha inativa");

        Doacao d = new Doacao();
        d.setCampanha(c);
        d.setDoador(v);
        d.setItem(c.getNome());
        d.setQuantidade(dto.getQuantidade());
        d.setStatus("CONFIRMADO");
        doacaoRepo.save(d);

        int novoTotal = c.getDoacoesRecebidas() + dto.getQuantidade();
        c.setDoacoesRecebidas(novoTotal);
        campanhaRepo.save(c);

        int restante = c.getMetaDoacoes() - novoTotal;
        String mensagem;
        if (restante < 0) {
            mensagem = "Meta atingida, mas você pode continuar doando!";
        } else if (restante == 0) {
            mensagem = "Parabéns! Meta exata alcançada.";
        } else {
            mensagem = "Faltam " + restante + " item(ns) para atingir a meta.";
        }

        return new DoacaoResponseDTO(c.getId(), novoTotal, Math.max(restante, 0), mensagem);
    }
}

