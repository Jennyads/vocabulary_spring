package br.gov.sp.fatec.springboot3topicos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3topicos.entity.Racao;
import br.gov.sp.fatec.springboot3topicos.repository.RacaoRepository;

@Service
public class RacaoService {


    @Autowired
    private RacaoRepository racaoRepo;

    public Racao nova(Racao racao) {
        if(racao.getDataHoraUltimaCompra() == null) {
            racao.setDataHoraUltimaCompra(LocalDateTime.now());
        }
        return racaoRepo.save(racao);
    }

    public List<Racao> buscarTodas() {
        return racaoRepo.findAll();
    }

    public List<Racao> buscarPorDataHoraCompraMenorOuEstoqueMenor(LocalDateTime dataHora, Float estoque) {
        return racaoRepo.queryByDataHoraUltimaCompraLessThanOrEstoqueLessThan(dataHora, estoque);
    }

}
