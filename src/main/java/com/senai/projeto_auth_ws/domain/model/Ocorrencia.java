package com.senai.projeto_auth_ws.domain.model;

import com.senai.projeto_auth_ws.domain.enums.StatusDaOcorrencia;
import com.senai.projeto_auth_ws.domain.enums.TipoDeOcorrencia;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDeOcorrencia tipo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusDaOcorrencia status;

    private LocalDateTime dataHoraCriacao;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Professor professorResponsavel;
}
