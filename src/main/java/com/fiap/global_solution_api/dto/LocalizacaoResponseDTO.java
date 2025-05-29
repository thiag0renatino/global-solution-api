package com.fiap.global_solution_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocalizacaoResponseDTO {

    private Long idLocalizacao;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDate dataCaptura;
    private DispositivoResponseDTO dispositivo;

    public LocalizacaoResponseDTO() {
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

    public DispositivoResponseDTO getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoResponseDTO dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalizacaoResponseDTO(Long idLocalizacao, LocalDate dataCaptura, BigDecimal longitude, BigDecimal latitude, DispositivoResponseDTO dispositivo) {
        this.idLocalizacao = idLocalizacao;
        this.dataCaptura = dataCaptura;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dispositivo = dispositivo;


    }
}
