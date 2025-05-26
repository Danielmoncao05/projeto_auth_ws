package com.senai.projeto_auth_ws.domain.model;

import com.senai.projeto_auth_ws.domain.enums.TipoDeUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // ou SINGLE_TABLE ou TABLE_PER_CLASS
@Data
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario;
}
