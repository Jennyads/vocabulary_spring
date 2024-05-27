package br.gov.sp.fatec.springboot3app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3app.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{
    
}
