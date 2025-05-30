package com.fiap.global_solution_api.dto;

import com.fiap.global_solution_api.enuns.TipoUsuario;

public class RegisterDTO {

    private String email;
    private String senha;
    private String nome;
    private TipoUsuario tipo;

    public RegisterDTO() {
    }

    public RegisterDTO(String email, String senha, String nome, TipoUsuario tipo) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
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

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

