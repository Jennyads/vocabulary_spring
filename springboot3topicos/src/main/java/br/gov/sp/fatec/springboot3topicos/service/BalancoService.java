package br.gov.sp.fatec.springboot3topicos.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Balanco;
import br.gov.sp.fatec.springboot3topicos.repository.BalancoRepository;

@Service
public class BalancoService {

    @Autowired
    private BalancoRepository repo;

    public List<Balanco> todos() {
        return repo.findAll();
    }

    public Balanco novo(Balanco balanco) {
        if(balanco == null ||
                balanco.getDescricao() == null ||
                balanco.getDescricao().isBlank()||
                balanco.getValor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(balanco.getDataHora() == null) {
            balanco.setDataHora(LocalDateTime.now());
        }
        return repo.save(balanco);
    }

    public List<Balanco> buscarPorDescricaoEValor(String descricao, BigDecimal valor) {
        return repo.findByDescricaoContainsIgnoreCaseAndValorGreaterThan(descricao, valor);
    }
    
}

