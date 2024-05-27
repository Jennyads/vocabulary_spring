package br.gov.sp.fatec.springboot3app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3app.entity.Vocabulo;

public interface VocabuloRepository extends JpaRepository<Vocabulo, Long>{

    public List<Vocabulo> findByTermoContainsAndVersao(String termo, Integer versao);
    
    @Query("select v from Vocabulo v where v.termo like %:termo% and v.versao = :versao")
    public List<Vocabulo> buscarPorTermoEVersao(String termo, Integer versao);

}
