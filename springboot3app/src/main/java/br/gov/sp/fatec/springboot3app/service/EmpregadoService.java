package br.gov.sp.fatec.springboot3app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app.entity.Empregado;
import br.gov.sp.fatec.springboot3app.repository.EmpregadoRepository;

@Service
public class EmpregadoService implements IEmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepo;

    @Override
    public Empregado novoEmpregado(Empregado empregado) {
        if(empregado == null || 
                empregado.getNomeCompleto() == null ||
                empregado.getCtps() == null ||
                empregado.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(empregado.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não pode ser preenchido!");
        }
        if(empregado.getDataHoraCadastro() == null) {
            empregado.setDataHoraCadastro(LocalDateTime.now());
        }
        return empregadoRepo.save(empregado);
    }

    @Override
    public List<Empregado> buscarTodos() {
        return empregadoRepo.findAll();
    }

    @Override
    public Empregado buscarPorCtpsOuEmail(Long ctps, String email) {
        return empregadoRepo.findByCtpsOrEmail(ctps, email);
    }
    
}
