package br.gov.sp.fatec.springboot3topicos.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3topicos.entity.Balanco;

public interface BalancoRepository extends JpaRepository<Balanco, Long>{

    public List<Balanco> findByDescricaoContainsIgnoreCaseAndValorGreaterThan(String descricao, BigDecimal valor);
    
}
