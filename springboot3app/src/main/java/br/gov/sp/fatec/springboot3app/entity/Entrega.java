package br.gov.sp.fatec.springboot3app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ent_entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ent_id")
    private Long id;

    @Column(name = "ent_descricao")
    private String descricao;
    
    @Column(name = "ent_data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;

    @Column(name = "ent_data_hora_limite")
    private LocalDateTime dataHoraLimite;

    @Column(name = "ent_peso")
    private Integer peso;

    @Column(name = "ent_observacoes")
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraLimite() {
        return dataHoraLimite;
    }

    public void setDataHoraLimite(LocalDateTime dataHoraLimite) {
        this.dataHoraLimite = dataHoraLimite;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
