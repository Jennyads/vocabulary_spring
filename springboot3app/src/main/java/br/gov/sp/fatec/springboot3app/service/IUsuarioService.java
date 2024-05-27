package br.gov.sp.fatec.springboot3app.service;

import java.util.List;

import br.gov.sp.fatec.springboot3app.entity.Anotacao;
import br.gov.sp.fatec.springboot3app.entity.Autorizacao;
import br.gov.sp.fatec.springboot3app.entity.Usuario;

public interface IUsuarioService {
    
    public Usuario novoUsuario(Usuario usuario);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public void associaAutorizacao(Long idUsuario, Long idAutorizacao);
    
    public Autorizacao novaAutorizacao(Autorizacao autorizacao);

    public Anotacao novaAnotacao(Anotacao anotacao);

}
