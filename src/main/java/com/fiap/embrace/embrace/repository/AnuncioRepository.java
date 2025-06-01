package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.AnuncioMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioRepository
        extends JpaRepository<AnuncioMarketplace, Long>,
        JpaSpecificationExecutor<AnuncioMarketplace> {
    List<AnuncioMarketplace> findByAutorId(Long autorId);
}
