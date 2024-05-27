package br.gov.sp.fatec.springboot3app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app.entity.Temperatura;
import br.gov.sp.fatec.springboot3app.repository.TemperaturaRepository;

@Service
public class TemperaturaService implements ITemperaturaService{

    @Autowired
    private TemperaturaRepository temperaturaRepo;

    @Override
    public Temperatura novaTemperatura(Temperatura temperatura) {
        if(temperatura == null ||
                temperatura.getMedida() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(temperatura.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não pode ser preenchido!");
        }
        if(temperatura.getDataHora() == null) {
            temperatura.setDataHora(LocalDateTime.now());
        }
        return temperaturaRepo.save(temperatura);
    }

    @Override
    public List<Temperatura> buscarTodas() {
        return temperaturaRepo.findAll();
    }

    @Override
    public List<Temperatura> buscarTemperaturasDataHoraMaiorEMedidaMaior(LocalDateTime dataHora, Float medida) {
        return temperaturaRepo.findByDataHoraGreaterThanAndMedidaGreaterThan(dataHora, medida);
    }
    
}
