package br.gov.sp.fatec.springboot3topicos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3topicos.entity.Encomenda;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long>{

    public List<Encomenda> findByConteudoContainsIgnoreCaseOrDataHoraPrevistaLessThan(String conteudo, LocalDateTime dataHoraPrevista);
    
}
