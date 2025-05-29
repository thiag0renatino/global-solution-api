package com.fiap.global_solution_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocalizacaoRequestDTO {

    private Long idLocalizacao;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDate dataCaptura;
    private Long idDispositivo;

    public LocalizacaoRequestDTO() {
    }

    public LocalizacaoRequestDTO(Long idLocalizacao, BigDecimal latitude, BigDecimal longitude, LocalDate dataCaptura, Long idDispositivo) {
        this.idLocalizacao = idLocalizacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataCaptura = dataCaptura;
        this.idDispositivo = idDispositivo;
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

    public Long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }
}
