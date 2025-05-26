package com.senai.projeto_auth_ws.interface_ui.controller;

import com.senai.projeto_auth_ws.application.service.AuthService;
import com.senai.projeto_auth_ws.infrastructure.util.JwtUtil;
import com.senai.projeto_auth_ws.domain.enums.TipoDeUsuario;
import com.senai.projeto_auth_ws.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        Usuario user = authService.authenticate(username, password);
        String token = jwtUtil.generateToken(user.getId(), user.getUsername(), String.valueOf(user.getTipoDeUsuario()));
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> payload) {
        String nome = payload.get("nome");
        String username = payload.get("username");
        String password = payload.get("password");
        TipoDeUsuario tipoDeUsuario = TipoDeUsuario.valueOf(payload.get("tipoDeUsuario"));
        Usuario user = authService.register(nome, username, password, tipoDeUsuario);
        return ResponseEntity.ok(Map.of("message", "Usuário cadastrado com sucesso", "id", user.getId()));
    }
}
