package com.fiap.global_solution_api.repository;

import com.fiap.global_solution_api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
