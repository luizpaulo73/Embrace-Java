package com.fiap.embrace.embrace.repository;


import com.fiap.embrace.embrace.entities.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {
    boolean existsByEmail(String email);
    boolean existsByCnpj(String cnpj);
}