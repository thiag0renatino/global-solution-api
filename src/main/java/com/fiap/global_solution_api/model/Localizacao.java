package com.fiap.global_solution_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localizacao_seq")
    @SequenceGenerator(name = "localizacao_seq", sequenceName = "SEQ_LOC", allocationSize = 1)
    private Long idLocalizacao;

    @Column(precision = 10, scale = 6)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 6)
    private BigDecimal longitude;

    private LocalDate dataCaptura;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id_dispositivo")
    private Dispositivo dispositivo;

    public Localizacao() {
    }

    public Localizacao(Long idLocalizacao, BigDecimal latitude, BigDecimal longitude, LocalDate dataCaptura, Dispositivo dispositivo) {
        this.idLocalizacao = idLocalizacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataCaptura = dataCaptura;
        this.dispositivo = dispositivo;
    }

    public Long getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Long idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public LocalDate getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(LocalDate dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
