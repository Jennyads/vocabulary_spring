package br.gov.sp.fatec.springboot3app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3app.entity.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{

    public Empregado findByCtpsOrEmail(Long ctps, String email);
    
}
