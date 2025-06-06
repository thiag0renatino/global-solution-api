package com.fiap.global_solution_api.dto;

import java.time.LocalDate;

public class PostRequestDTO {

    private String titulo;
    private String conteudo;
    private LocalDate dataCriacao;
    private String sincronizado;
    private Long idUsuario;

    public PostRequestDTO() {
    }

    public PostRequestDTO(String titulo, String conteudo, LocalDate dataCriacao, String sincronizado, Long idUsuario) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.sincronizado = sincronizado;
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
