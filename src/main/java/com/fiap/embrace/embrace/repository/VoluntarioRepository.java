package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.Voluntario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
    boolean existsByEmail(String email);

    Page<Voluntario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
