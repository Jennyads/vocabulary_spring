package br.gov.sp.fatec.springboot3app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3app.entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    public List<Entrega> findByDataHoraLimiteGreaterThan(LocalDateTime limite);
    
}
