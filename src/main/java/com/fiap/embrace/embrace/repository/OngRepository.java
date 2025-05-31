package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.Ong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {

    boolean existsByEmail(String email);
    boolean existsByCnpj(String cnpj);

    Page<Ong> findByNomeContainingIgnoreCaseAndCnpjContainingIgnoreCase(
            String nome, String cnpj, Pageable pageable
    );

    Page<Ong> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Ong> findByCnpjContainingIgnoreCase(String cnpj, Pageable pageable);
}
