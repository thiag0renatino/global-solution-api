package com.fiap.global_solution_api.dto;

public class DispositivoResponseDTO {

    private Long idDispositivo;
    private String uuid;
    private UsuarioResponseDTO usuario;

    public DispositivoResponseDTO() {
    }

    public DispositivoResponseDTO(Long idDispositivo, String uuid, UsuarioResponseDTO usuario) {
        this.idDispositivo = idDispositivo;
        this.uuid = uuid;
        this.usuario = usuario;
    }

    public Long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }
}
