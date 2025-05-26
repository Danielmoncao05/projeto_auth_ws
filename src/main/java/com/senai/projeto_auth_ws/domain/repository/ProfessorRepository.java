package com.senai.projeto_auth_ws.domain.repository;

import com.senai.projeto_auth_ws.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Optional<Professor> findFirstByOrderByIdAsc();
}
