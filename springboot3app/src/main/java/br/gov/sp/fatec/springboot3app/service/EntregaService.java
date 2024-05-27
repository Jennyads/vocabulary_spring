package br.gov.sp.fatec.springboot3app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app.entity.Entrega;
import br.gov.sp.fatec.springboot3app.repository.EntregaRepository;

@Service
public class EntregaService implements IEntregaService{

    @Autowired
    private EntregaRepository entregaRepo;

    @Override
    public Entrega novaEntrega(Entrega entrega) {
        if(entrega == null || 
                entrega.getDescricao() == null ||
                entrega.getPeso() == null ||
                entrega.getDataHoraLimite() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(entrega.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não pode ser preenchido!");
        }
        if(entrega.getDataHoraCadastro() == null) {
            entrega.setDataHoraCadastro(LocalDateTime.now());
        }
        return entregaRepo.save(entrega);
    }

    @Override
    public List<Entrega> buscarDataLimiteSuperior(LocalDateTime limite) {
        return entregaRepo.findByDataHoraLimiteGreaterThan(limite);
    }

    @Override
    public List<Entrega> buscarTodas() {
        return entregaRepo.findAll();
    }
    
}
