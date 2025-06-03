package com.fiap.global_solution_api.dto;

public class SolicitacaoVerificacaoRequestDTO {

    private Long idSolicitacao;
    private String documento;
    private String observacao;

    public SolicitacaoVerificacaoRequestDTO() {
    }

    public SolicitacaoVerificacaoRequestDTO(Long idSolicitacao, String documento, String observacao) {
        this.idSolicitacao = idSolicitacao;
        this.documento = documento;
        this.observacao = observacao;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
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
}
