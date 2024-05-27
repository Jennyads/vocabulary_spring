package br.gov.sp.fatec.springboot3app.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome")
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private Set<Anotacao> anotacoes;

    @ManyToMany(mappedBy = "usuarios")
    private Set<Autorizacao> autorizacoes;

    public Usuario(String nome, String senha) {
        this();
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {
        this.anotacoes = new HashSet<Anotacao>();
        this.autorizacoes = new HashSet<Autorizacao>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(Set<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

}
