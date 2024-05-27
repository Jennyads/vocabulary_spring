package br.gov.sp.fatec.springboot3app.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springboot3app.entity.Temperatura;

public interface ITemperaturaService {

    public Temperatura novaTemperatura(Temperatura temperatura);

    public List<Temperatura> buscarTodas();

    public List<Temperatura> buscarTemperaturasDataHoraMaiorEMedidaMaior(LocalDateTime dataHora, Float medida);
    
}
