package br.gov.sp.fatec.springboot3app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voc_vocabulo")
public class Vocabulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private Long id;

    @Column(name = "voc_termo")
    private String termo;

    @Column(name = "voc_significado")
    private String significado;

    @Column(name = "voc_versao")
    private Integer versao;

    @Column(name = "voc_data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;

    @Column(name = "voc_data_hora_desativacao")
    private LocalDateTime dataHoraDesativacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraDesativacao() {
        return dataHoraDesativacao;
    }

    public void setDataHoraDesativacao(LocalDateTime dataHoraDesativacao) {
        this.dataHoraDesativacao = dataHoraDesativacao;
    }


}
