package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.SolicitacaoTipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoTipoUsuarioRepository extends JpaRepository<SolicitacaoTipoUsuario, Long> {

    List<SolicitacaoTipoUsuario> findByUsuarioIdUsuario(Long idUsuario);
}
