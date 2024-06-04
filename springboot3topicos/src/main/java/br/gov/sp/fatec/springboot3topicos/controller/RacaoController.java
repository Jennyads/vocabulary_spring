package br.gov.sp.fatec.springboot3topicos.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3topicos.entity.Racao;
import br.gov.sp.fatec.springboot3topicos.service.RacaoService;

@RestController
@RequestMapping(value = "/racao")
@CrossOrigin
public class RacaoController {
    
    @Autowired
    private RacaoService service;

    @GetMapping
    public List<Racao> buscarTodasRacoes() {
        return service.buscarTodas();
    }

    @PostMapping
    public Racao cadastrarNovaRacao(@RequestBody Racao racao) {
        return service.nova(racao);
    }
    
    @GetMapping(value = "/{dataHora}/{estoque}")
    public List<Racao> buscarPorDataHoraMenorOuEstoqueMenor(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("estoque") Float estoque) {
        return service.buscarPorDataHoraCompraMenorOuEstoqueMenor(dataHora, estoque);
    }
}
