package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    boolean existsByUuid(String uuid);

}
