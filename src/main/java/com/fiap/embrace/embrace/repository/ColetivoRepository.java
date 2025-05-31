package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.Coletivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetivoRepository extends JpaRepository<Coletivo, Long> {
    boolean existsByEmail(String email);

    Page<Coletivo> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
