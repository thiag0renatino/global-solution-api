package com.fiap.global_solution_api.model;

import com.fiap.global_solution_api.enuns.StatusVerificacao;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SolicitacaoTipoUsuario {

    @Id
    private Long idSolicitacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String documento;

    @Column(length = 1000)
    private String observacao;

    @Enumerated(EnumType.STRING)
    private StatusVerificacao status;

    private LocalDateTime dataSolicitacao;

    public SolicitacaoTipoUsuario() {
    }

    public SolicitacaoTipoUsuario(Long idSolicitacao, Usuario usuario, String documento, String observacao, StatusVerificacao status, LocalDateTime dataSolicitacao) {
        this.idSolicitacao = idSolicitacao;
        this.usuario = usuario;
        this.documento = documento;
        this.observacao = observacao;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusVerificacao getStatus() {
        return status;
    }

    public void setStatus(StatusVerificacao status) {
        this.status = status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
