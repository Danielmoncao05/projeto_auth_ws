package com.senai.projeto_auth_ws.domain.repository;

import com.senai.projeto_auth_ws.domain.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
