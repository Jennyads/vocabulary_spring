package br.gov.sp.fatec.springboot3app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tmp_temperatura")
public class Temperatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tmp_id")
    private Long id;

    @Column(name = "tmp_data_hora")
    private LocalDateTime dataHora;

    @Column(name = "tmp_medida")
    private Float medida;

    @Column(name = "tmp_umidade")
    private Float umidade;

    @Column(name = "tmp_vento")
    private Float vento;

    @Column(name = "tmp_particulas")
    private Float particulas;

    public Temperatura() {}

    public Temperatura(LocalDateTime dataHora, Float medida) {
        this.dataHora = dataHora;
        this.medida = medida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Float getMedida() {
        return medida;
    }

    public void setMedida(Float medida) {
        this.medida = medida;
    }

    public Float getUmidade() {
        return umidade;
    }

    public void setUmidade(Float umidade) {
        this.umidade = umidade;
    }

    public Float getVento() {
        return vento;
    }

    public void setVento(Float vento) {
        this.vento = vento;
    }

    public Float getParticulas() {
        return particulas;
    }

    public void setParticulas(Float particulas) {
        this.particulas = particulas;
    }


    
}
