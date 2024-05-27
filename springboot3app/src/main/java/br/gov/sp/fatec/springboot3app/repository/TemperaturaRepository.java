package br.gov.sp.fatec.springboot3app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3app.entity.Temperatura;

public interface TemperaturaRepository extends JpaRepository<Temperatura, Long>{

    public List<Temperatura> findByDataHoraGreaterThanAndMedidaGreaterThan(LocalDateTime dataHora, Float medida);
    
}
