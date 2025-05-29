package com.fiap.global_solution_api.dto;

public class UsuarioResponseDTO {

    private Long idUsuario;
    private String email;
    private String nome;
    private String tipo;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long idUsuario, String email, String nome, String tipo) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
