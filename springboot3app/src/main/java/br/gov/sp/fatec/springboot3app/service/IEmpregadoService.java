package br.gov.sp.fatec.springboot3app.service;

import java.util.List;

import br.gov.sp.fatec.springboot3app.entity.Empregado;

public interface IEmpregadoService {

    public Empregado novoEmpregado(Empregado empregado);

    public List<Empregado> buscarTodos();

    public Empregado buscarPorCtpsOuEmail(Long ctps, String email);
    
}
