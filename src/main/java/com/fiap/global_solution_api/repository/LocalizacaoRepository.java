package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
}
