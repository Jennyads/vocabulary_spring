package br.gov.sp.fatec.springboot3app.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springboot3app.entity.Entrega;

public interface IEntregaService {

    public List<Entrega> buscarDataLimiteSuperior(LocalDateTime limite);

    public List<Entrega> buscarTodas();

    public Entrega novaEntrega(Entrega entrega);
    
}
