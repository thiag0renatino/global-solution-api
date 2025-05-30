package com.fiap.global_solution_api.enuns;

public enum TipoUsuario {
    SOCORRISTA("socorrista"),
    COMUM("comum");

    private String tipo;

    TipoUsuario(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }


}
