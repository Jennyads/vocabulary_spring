package br.gov.sp.fatec.springboot3topicos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3topicos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByNome(String nomeUsuario);

    @Query("select u from Usuario u where u.nome = ?1")
    public Optional<Usuario> buscarPorNome(String nomeUsuario);

    public List<Usuario> findByNomeContains(String nomeUsuario);

    @Query("select u from Usuario u where u.nome like %?1%")
    public List<Usuario> buscarPorNomeContido(String nomeUsuario);

    public Optional<Usuario> findByNomeAndSenha(String nomeUsuario, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Optional<Usuario> buscarPorNomeESenha(String nomeUsuario, String senha);

    public List<Usuario> findByAutorizacoesNome(String nomeAutorizacao);

    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscarPorNomeAutorizacao(String nomeAutorizacao);

    public List<Usuario> findByIdGreaterThan(Long id);

    @Query("select u from Usuario u where u.id > ?1")
    public List<Usuario> buscarPorIdMaior(Long id);

}
