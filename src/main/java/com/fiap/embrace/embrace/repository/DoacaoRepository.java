package com.fiap.embrace.embrace.repository;

import com.fiap.embrace.embrace.entities.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
    List<Doacao> findByDoadorId(Long doadorId);
}
