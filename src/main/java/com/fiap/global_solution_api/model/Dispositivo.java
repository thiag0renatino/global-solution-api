package com.fiap.global_solution_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispositivo_seq")
    @SequenceGenerator(name = "dispositivo_seq", sequenceName = "SEQ_DISP", allocationSize = 1)
    private Long idDispositivo;

    @Column(unique = true, length = 100)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "dispositivo", cascade = CascadeType.ALL)
    private List<Localizacao> localizacoes;

    @OneToMany(mappedBy = "origem", cascade = CascadeType.ALL)
    private List<Mensagem> mensagensOrigem;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    private List<Mensagem> mensagensDestino;

    public Dispositivo() {
    }

    public Dispositivo(Long idDispositivo, String uuid, Usuario usuario, List<Localizacao> localizacoes, List<Mensagem> mensagensOrigem, List<Mensagem> mensagensDestino) {
        this.idDispositivo = idDispositivo;
        this.uuid = uuid;
        this.usuario = usuario;
        this.localizacoes = localizacoes;
        this.mensagensOrigem = mensagensOrigem;
        this.mensagensDestino = mensagensDestino;
    }

    public Long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }

    public List<Mensagem> getMensagensOrigem() {
        return mensagensOrigem;
    }

    public void setMensagensOrigem(List<Mensagem> mensagensOrigem) {
        this.mensagensOrigem = mensagensOrigem;
    }

    public List<Mensagem> getMensagensDestino() {
        return mensagensDestino;
    }

    public void setMensagensDestino(List<Mensagem> mensagensDestino) {
        this.mensagensDestino = mensagensDestino;
    }
}
