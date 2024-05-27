package br.gov.sp.fatec.springboot3app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3app.entity.Vocabulo;
import br.gov.sp.fatec.springboot3app.repository.VocabuloRepository;

@Service
public class VocabuloService {
    
    @Autowired
    private VocabuloRepository vocabuloRepo;

    public Vocabulo novoVocabulo(Vocabulo vocabulo) {
        vocabulo.setDataHoraCadastro(LocalDateTime.now());
        return vocabuloRepo.save(vocabulo);
    }

    public List<Vocabulo> todosVocabulos() {
        return vocabuloRepo.findAll();
    }

    public List<Vocabulo> buscarPorTermoEVersao(String termo, Integer versao) {
        return vocabuloRepo.buscarPorTermoEVersao(termo, versao);
    }

}
