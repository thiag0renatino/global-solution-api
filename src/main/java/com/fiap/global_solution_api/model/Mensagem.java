package com.fiap.global_solution_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Mensagem {

    @Id
    private Long idMensagem;

    @Column(length = 1000)
    private String texto;

    private LocalDate dataEnvio;

    private String sincronizado;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Dispositivo origem;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Dispositivo destino;

    public Mensagem() {
    }

    public Mensagem(Long idMensagem, String texto, String sincronizado, LocalDate dataEnvio, Dispositivo origem, Dispositivo destino) {
        this.idMensagem = idMensagem;
        this.texto = texto;
        this.sincronizado = sincronizado;
        this.dataEnvio = dataEnvio;
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

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    public Dispositivo getOrigem() {
        return origem;
    }

    public void setOrigem(Dispositivo origem) {
        this.origem = origem;
    }

    public Dispositivo getDestino() {
        return destino;
    }

    public void setDestino(Dispositivo destino) {
        this.destino = destino;
    }
}
