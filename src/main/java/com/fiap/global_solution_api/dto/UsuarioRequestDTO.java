package com.fiap.global_solution_api.dto;

public class UsuarioRequestDTO {

    private Long idUsuario;
    private String email;
    private String senha;
    private String nome;
    private String tipo;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(Long idUsuario, String tipo, String senha, String email, String nome) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
