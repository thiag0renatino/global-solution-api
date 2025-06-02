package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    List<Mensagem> findByOrigemIdDispositivoAndSincronizado(Long idDispositivo, String sincronizado);
}
