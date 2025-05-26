package com.senai.projeto_auth_ws.domain.repository;

import com.senai.projeto_auth_ws.domain.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Long> {
}
