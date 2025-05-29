package com.fiap.global_solution_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Usuario {

    @Id
    private Long idUsuario;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    @Column(length = 100)
    private String nome;

    @Column(length = 20)
    private String tipo;

    @OneToMany(mappedBy = "usuario")
    private List<Dispositivo> dispositivos;

    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String senha, String email, String nome, String tipo, List<Dispositivo> dispositivos, List<Post> posts) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
        this.dispositivos = dispositivos;
        this.posts = posts;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
