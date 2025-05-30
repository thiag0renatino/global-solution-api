package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
