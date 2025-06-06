package com.fiap.global_solution_api.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msn_seq")
    @SequenceGenerator(name = "msn_seq", sequenceName = "SEQ_MSN", allocationSize = 1)
    private Long idMensagem;

    @Column(length = 1000)
    private String texto;

    private LocalDateTime dataEnvio;

    private String sincronizado;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Dispositivo origem;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Dispositivo destino;

    public Mensagem() {
    }

    public Mensagem(Long idMensagem, String texto, LocalDateTime dataEnvio, String sincronizado, Dispositivo origem, Dispositivo destino) {
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
