package br.gov.sp.fatec.springboot3app.controller;

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

import br.gov.sp.fatec.springboot3app.entity.Entrega;
import br.gov.sp.fatec.springboot3app.service.IEntregaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/entrega")
public class EntregaController {

    @Autowired
    private IEntregaService service;

    @GetMapping
    public List<Entrega> buscarTodas() {
        return service.buscarTodas();
    }

    @PostMapping
    public Entrega novaEntrega(@RequestBody Entrega entrega) {
        return service.novaEntrega(entrega);
    }

    @GetMapping(value = "/{limite}")
    public List<Entrega> buscarDataLimiteSuperior(@PathVariable("limite") LocalDateTime limite) {
        return service.buscarDataLimiteSuperior(limite);
    }
    
}
