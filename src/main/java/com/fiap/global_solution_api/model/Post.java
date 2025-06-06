package com.fiap.global_solution_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "SEQ_POST", allocationSize = 1)
    private Long idPost;

    @NotBlank
    @Column(length = 50)
    private String titulo;

    @Column(length = 1000)
    private String conteudo;

    private LocalDate dataCriacao;

    private String sincronizado;

    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    public Post() {
    }

    public Post(Long idPost, String conteudo, LocalDate dataCriacao, String sincronizado, Usuario usuario, String titulo) {
        this.idPost = idPost;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.sincronizado = sincronizado;
        this.usuario = usuario;
        this.titulo = titulo;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
