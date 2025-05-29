package com.fiap.global_solution_api.dto;

import java.time.LocalDate;

public class PostResponseDTO {

    private Long idPost;
    private String titulo;
    private String conteudo;
    private LocalDate dataCriacao;
    private String sincronizado;
    private UsuarioResponseDTO usuario;

    public PostResponseDTO() {
    }

    public PostResponseDTO(Long idPost, String titulo, String conteudo, String sincronizado, LocalDate dataCriacao, UsuarioResponseDTO usuario) {
        this.idPost = idPost;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.sincronizado = sincronizado;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
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

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }
}
