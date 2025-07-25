package com.senai.projeto_auth_ws.application.service;

import com.senai.projeto_auth_ws.domain.enums.TipoDeUsuario;
import com.senai.projeto_auth_ws.domain.repository.UsuarioRepository;
import com.senai.projeto_auth_ws.domain.model.AQV;
import com.senai.projeto_auth_ws.domain.model.Aluno;
import com.senai.projeto_auth_ws.domain.model.Professor;
import com.senai.projeto_auth_ws.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder; // biblioteca da propria jwt // criptografa a senha  // jwt - lida com as tranformações em json

    public Usuario authenticate(String username, String password) {
        return usuarioRepository.findByUsername(username) // passando e procurando no banco de dados alguem que tenha o username
                .filter(user -> passwordEncoder.matches(password, user.getPassword())) // ver se passa a senha que foi passado e ver se bate com a senha do usuario no banco de dados
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
    }

    public Usuario register(String nome, String username, String password, TipoDeUsuario tipoDeUsuario ) { 
        Usuario user; // usuario abstrato
        switch (tipoDeUsuario) { // de acordo com o tipo de usuario para ter a instancia certa
            case ALUNO -> user = new Aluno();
            case PROFESSOR -> user = new Professor();
            case AQV -> user = new AQV();
            default -> throw new IllegalArgumentException("Tipo de Usuário inválido");
        }
        user.setNome(nome);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); //
        user.setTipoDeUsuario(tipoDeUsuario);
        return usuarioRepository.save(user);
    }
}


