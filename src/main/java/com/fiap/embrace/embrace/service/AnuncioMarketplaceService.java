package com.fiap.embrace.embrace.service;

import com.fiap.embrace.embrace.entities.AnuncioMarketplace;
import com.fiap.embrace.embrace.repository.AnuncioMarketplaceRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnuncioMarketplaceService {

    private final AnuncioMarketplaceRepository anuncioRepository;

    public AnuncioMarketplaceService(AnuncioMarketplaceRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    public void verificarAnunciosExpirados() {
        List<AnuncioMarketplace> anuncios = anuncioRepository.findAll();

        for (AnuncioMarketplace anuncio : anuncios) {
            if (anuncio.isAtivo() && anuncio.getDataFim().isBefore(LocalDateTime.now())) {
                anuncio.setAtivo(false);
                anuncioRepository.save(anuncio);
            }
        }
    }

    public List<AnuncioMarketplace> listarTodos() {
        verificarAnunciosExpirados();  // atualiza os expirados antes de listar
        return anuncioRepository.findAll();
    }

    @Scheduled(cron = "0 0 * * * *")  // a cada hora
    public void verificarAnunciosExpiradosPeriodicamente() {
        verificarAnunciosExpirados();
    }
}
