package com.fiap.global_solution_api.dto;

public class AtualizarNomeRequestDTO {

    private String nome;

    public AtualizarNomeRequestDTO() {
    }

    public AtualizarNomeRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
