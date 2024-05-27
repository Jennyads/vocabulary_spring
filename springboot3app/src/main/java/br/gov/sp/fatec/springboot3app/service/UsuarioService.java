package br.gov.sp.fatec.springboot3app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app.entity.Anotacao;
import br.gov.sp.fatec.springboot3app.entity.Autorizacao;
import br.gov.sp.fatec.springboot3app.entity.Usuario;
import br.gov.sp.fatec.springboot3app.repository.AnotacaoRepository;
import br.gov.sp.fatec.springboot3app.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springboot3app.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private AnotacaoRepository anotRepo;

    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Dados inválidos!");
        }
        try {
            Set<Autorizacao> autorizacoes = usuario.getAutorizacoes();
            usuario.setAutorizacoes(new HashSet<Autorizacao>());
            usuario = usuarioRepo.save(usuario);
            if(!autorizacoes.isEmpty()) {
              for(Autorizacao autorizacao: autorizacoes) {
                    Autorizacao autorizacaoBd = buscarAutorizacaoPorId(autorizacao.getId());
                    autorizacaoBd.getUsuarios().add(usuario);
                    usuario.getAutorizacoes().add(autRepo.save(autorizacaoBd));
                }
            }
            usuario = usuarioRepo.save(usuario);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao inserir usuário!");
        }
        return usuario;
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        return usuarioOp.get();
    }

    public Autorizacao buscarAutorizacaoPorId(Long id) {
        Optional<Autorizacao> autOp = autRepo.findById(id);
        if(autOp.isEmpty()) {
            throw new IllegalArgumentException("Autorização não encontrada!");
        }
        return autOp.get();
    }

    @Override
    public void associaAutorizacao(Long idUsuario, Long idAutorizacao) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Autorizacao aut = buscarAutorizacaoPorId(idAutorizacao);
        aut.getUsuarios().add(usuario);
        autRepo.save(aut);
    }

    @Override
    public Autorizacao novaAutorizacao(Autorizacao autorizacao) {
        Set<Usuario> usuarios = new HashSet<Usuario>();
        for(Usuario usuario: autorizacao.getUsuarios()) {
            Usuario usuarioBd = buscarUsuarioPorId(usuario.getId());
            usuarios.add(usuarioBd);
        }
        autorizacao.setUsuarios(usuarios);
        return autRepo.save(autorizacao);
    }

    @Override
    public Anotacao novaAnotacao(Anotacao anotacao) {
        Usuario usuario = buscarUsuarioPorId(anotacao.getUsuario().getId());
        anotacao.setUsuario(usuario);
        return anotRepo.save(anotacao);
    }
    
}
