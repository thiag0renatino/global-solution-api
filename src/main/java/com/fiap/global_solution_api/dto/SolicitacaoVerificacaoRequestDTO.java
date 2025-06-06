package com.fiap.global_solution_api.dto;

public class SolicitacaoVerificacaoRequestDTO {

    private String documento;
    private String observacao;

    public SolicitacaoVerificacaoRequestDTO() {
    }

    public SolicitacaoVerificacaoRequestDTO(String documento, String observacao) {
        this.documento = documento;
        this.observacao = observacao;
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
