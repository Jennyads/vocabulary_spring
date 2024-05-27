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

import br.gov.sp.fatec.springboot3app.entity.Temperatura;
import br.gov.sp.fatec.springboot3app.service.ITemperaturaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/temperatura")
public class TemperaturaController {

    @Autowired
    private ITemperaturaService service;

    @GetMapping
    public List<Temperatura> buscarTodas() {
        return service.buscarTodas();
    }

    @PostMapping
    public Temperatura novaTemperatura(@RequestBody Temperatura temperatura) {
        return service.novaTemperatura(temperatura);
    }

    @GetMapping(value = "/{dataHora}/{medida}")
    public List<Temperatura> buscarTemperaturasDataHoraMaiorEMedidaMaior(@PathVariable("dataHora") LocalDateTime dataHora, @PathVariable("medida") Float medida) {
        return service.buscarTemperaturasDataHoraMaiorEMedidaMaior(dataHora, medida);
    }    
    
}
