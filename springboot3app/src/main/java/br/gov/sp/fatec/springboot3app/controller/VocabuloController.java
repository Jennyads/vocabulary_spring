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

import br.gov.sp.fatec.springboot3app.entity.Vocabulo;
import br.gov.sp.fatec.springboot3app.service.VocabuloService;

@RestController
@RequestMapping(value = "/vocabulo")
@CrossOrigin
public class VocabuloController {

    @Autowired
    private VocabuloService service;

    @GetMapping
    public List<Vocabulo> todosVocabulos() {
        return service.todosVocabulos();
    }

    @PostMapping
    public Vocabulo novoVocabulo(@RequestBody Vocabulo vocabulo) {
        return service.novoVocabulo(vocabulo);
    }

    @GetMapping(value = "/{termo}/{versao}")
    public List<Vocabulo> buscarPorTermoEVersao(@PathVariable("termo") String termo, @PathVariable("versao") Integer versao) {
        return service.buscarPorTermoEVersao(termo, versao);
    }

    
}
