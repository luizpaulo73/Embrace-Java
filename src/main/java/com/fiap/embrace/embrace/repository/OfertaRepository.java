package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    List<Oferta> findByAnuncioId(Long anuncioId);
    List<Oferta> findByDoadorId(Long doadorId);
}
