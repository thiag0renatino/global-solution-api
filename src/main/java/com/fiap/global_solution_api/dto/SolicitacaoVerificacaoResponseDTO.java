package com.fiap.global_solution_api.dto;

import com.fiap.global_solution_api.model.Usuario;

import java.time.LocalDateTime;

public class SolicitacaoVerificacaoResponseDTO {

    private Long idSolicitacao;
    private Long idUsuario;
    private String documento;
    private String observacao;
    private String status;
    private LocalDateTime dataSolicitacao;

    public SolicitacaoVerificacaoResponseDTO() {
    }

    public SolicitacaoVerificacaoResponseDTO(Long idSolicitacao, Long idUsuario, String documento, String observacao, String status, LocalDateTime dataSolicitacao) {
        this.idSolicitacao = idSolicitacao;
        this.idUsuario = idUsuario;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
