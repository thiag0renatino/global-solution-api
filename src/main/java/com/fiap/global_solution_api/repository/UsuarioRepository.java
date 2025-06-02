package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);

    List<Usuario> findByNomeStartsWithIgnoreCase(String nome);
}
