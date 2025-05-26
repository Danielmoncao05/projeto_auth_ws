package com.senai.projeto_auth_ws.interface_ui.dto;

import com.senai.projeto_auth_ws.domain.enums.StatusDaOcorrencia;
import com.senai.projeto_auth_ws.domain.enums.TipoDeOcorrencia;
import com.senai.projeto_auth_ws.domain.model.Ocorrencia;

import java.time.LocalDateTime;

public record OcorrenciaDTO(
        Long id,
        TipoDeOcorrencia tipo,
        String descricao,
        StatusDaOcorrencia status,
        LocalDateTime dataHoraCriacao,
        Long alunoId,
        Long professorResponsavelId
) {
    public static OcorrenciaDTO toDTO(Ocorrencia ocorrencia) {
        return new OcorrenciaDTO(
                ocorrencia.getId(),
                ocorrencia.getTipo(),
                ocorrencia.getDescricao(),
                ocorrencia.getStatus(),
                ocorrencia.getDataHoraCriacao(),
                ocorrencia.getAluno() != null ? ocorrencia.getAluno().getId() : null,
                ocorrencia.getProfessorResponsavel() != null ? ocorrencia.getProfessorResponsavel().getId() : null
        );
    }

    public Ocorrencia fromDTO() {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(id);
        ocorrencia.setTipo(tipo);
        ocorrencia.setDescricao(descricao);
        ocorrencia.setStatus(status);
        ocorrencia.setDataHoraCriacao(dataHoraCriacao);
        return ocorrencia;
    }
}