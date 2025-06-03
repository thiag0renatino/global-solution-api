package com.fiap.global_solution_api.dto;

import java.time.LocalDateTime;

public class MensagemResponseDTO {

    private Long idMensagem;
    private String texto;
    private LocalDateTime dataEnvio;
    private String sincronizado;
    private DispositivoResponseDTO origem;
    private DispositivoResponseDTO destino;

    public MensagemResponseDTO() {
    }

    public MensagemResponseDTO(Long idMensagem, String texto, LocalDateTime dataEnvio, String sincronizado, DispositivoResponseDTO origem, DispositivoResponseDTO destino) {
        this.idMensagem = idMensagem;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
        this.sincronizado = sincronizado;
        this.origem = origem;
        this.destino = destino;
    }

    public Long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public DispositivoResponseDTO getOrigem() {
        return origem;
    }

    public void setOrigem(DispositivoResponseDTO origem) {
        this.origem = origem;
    }

    public DispositivoResponseDTO getDestino() {
        return destino;
    }

    public void setDestino(DispositivoResponseDTO destino) {
        this.destino = destino;
    }
}
