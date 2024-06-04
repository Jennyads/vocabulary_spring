package br.gov.sp.fatec.springboot3topicos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3topicos.entity.Racao;

public interface RacaoRepository extends JpaRepository<Racao, Long>{

    public List<Racao> queryByDataHoraUltimaCompraLessThanOrEstoqueLessThan(LocalDateTime dataHora, Float estoque);

}
  