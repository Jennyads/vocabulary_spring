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

import br.gov.sp.fatec.springboot3topicos.entity.Encomenda;
import br.gov.sp.fatec.springboot3topicos.service.EncomendaService;

@RestController
@RequestMapping(value = "/encomenda")
@CrossOrigin
public class EncomendaController {

    @Autowired
    private EncomendaService service;

    @GetMapping
    public List<Encomenda> buscarTodas() {
        return service.todas();
    }

    @PostMapping
    public Encomenda nova(@RequestBody Encomenda encomenda) {
        return service.nova(encomenda);
    }

    @GetMapping(value = "/{conteudo}/{dataHoraPrevista}")
    public List<Encomenda> buscarPorConteudoOuDataHoraPrevista(@PathVariable("conteudo") String conteudo, @PathVariable("dataHoraPrevista") LocalDateTime dataHoraPrevista) {
        return service.buscarPorConteudoOuDataHoraPrevista(conteudo, dataHoraPrevista);
    }
    

}

