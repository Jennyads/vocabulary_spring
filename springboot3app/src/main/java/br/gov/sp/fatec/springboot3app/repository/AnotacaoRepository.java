package br.gov.sp.fatec.springboot3app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3app.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
}
