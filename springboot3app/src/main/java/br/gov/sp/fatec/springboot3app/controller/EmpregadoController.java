package br.gov.sp.fatec.springboot3app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3app.entity.Empregado;
import br.gov.sp.fatec.springboot3app.service.IEmpregadoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/empregado")
public class EmpregadoController {

    @Autowired
    private IEmpregadoService service;

    @GetMapping
    public List<Empregado> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public Empregado novaEntrega(@RequestBody Empregado empregado) {
        return service.novoEmpregado(empregado);
    }

    @GetMapping(value = "/{ctps}/{email}")
    public Empregado buscarPorCtpsOuEmail(@PathVariable("ctps") Long ctps, @PathVariable("email") String email) {
        return service.buscarPorCtpsOuEmail(ctps, email);
    }
    
}
