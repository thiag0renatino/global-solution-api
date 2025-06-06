package com.fiap.global_solution_api.dto;

import java.time.LocalDateTime;

public class MensagemRequestDTO {

    private String texto;
    private LocalDateTime dataEnvio;
    private String sincronizado;
    private Long idOrigem;
    private Long idDestino;

    public MensagemRequestDTO() {
    }

    public MensagemRequestDTO(String texto, LocalDateTime dataEnvio, String sincronizado, Long idOrigem, Long idDestino) {
        this.texto = texto;
        this.dataEnvio = dataEnvio;
        this.sincronizado = sincronizado;
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(Long idOrigem) {
        this.idOrigem = idOrigem;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }
}
