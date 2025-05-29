package com.fiap.global_solution_api.dto;

import java.time.LocalDate;

public class MensagemRequestDTO {

    private Long idMensagem;
    private String texto;
    private LocalDate dataEnvio;
    private String sincronizado;
    private Long idOrigem;
    private Long idDestino;

    public MensagemRequestDTO() {
    }

    public MensagemRequestDTO(Long idMensagem, String texto, LocalDate dataEnvio, String sincronizado, Long idOrigem, Long idDestino) {
        this.idMensagem = idMensagem;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
        this.sincronizado = sincronizado;
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
    }

    public Long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
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
