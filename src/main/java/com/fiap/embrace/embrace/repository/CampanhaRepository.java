package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.Campanha;
import com.fiap.embrace.embrace.entities.TipoEvento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    List<Campanha> findByCriadorId(Long criadorId);

    Page<Campanha> findByAtivoTrue(Pageable pageable);

    Page<Campanha> findByAtivoTrueAndCidadeEstadoContainingIgnoreCase(String cidadeEstado, Pageable pageable);

    Page<Campanha> findByAtivoTrueAndTipoEvento(TipoEvento tipoEvento, Pageable pageable);

    Page<Campanha> findByAtivoTrueAndCidadeEstadoContainingIgnoreCaseAndTipoEvento(
            String cidadeEstado, TipoEvento tipoEvento, Pageable pageable
    );
}
