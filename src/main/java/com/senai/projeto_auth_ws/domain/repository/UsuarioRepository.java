package com.senai.projeto_auth_ws.domain.repository;

import com.senai.projeto_auth_ws.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
   Optional<Usuario> findByUsername(String username); // procura o usuario atraves do username
}
