package com.fiap.global_solution_api.dto;

public class DispositivoRequestDTO {

    private Long idDispositivo;
    private String uuid;
    private Long idUsuario;

    public DispositivoRequestDTO() {
    }

    public DispositivoRequestDTO(Long idDispositivo, String uuid, Long idUsuario) {
        this.idDispositivo = idDispositivo;
        this.uuid = uuid;
        this.idUsuario = idUsuario;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
