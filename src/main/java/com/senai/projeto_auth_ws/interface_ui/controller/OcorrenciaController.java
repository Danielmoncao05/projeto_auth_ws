package com.senai.projeto_auth_ws.interface_ui.controller;

import com.senai.projeto_auth_ws.application.service.OcorrenciaService;
import com.senai.projeto_auth_ws.interface_ui.dto.OcorrenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @MessageMapping("/ocorrencia/saida")
    public void solicitarSaida(@Payload OcorrenciaDTO dto) {
        ocorrenciaService.solicitarSaidaAntecipada(dto);
    }

    @MessageMapping("/ocorrencia/decisao")
    public void decidirSaida(@Payload OcorrenciaDTO dto) {
        ocorrenciaService.decidirSaida(dto);
    }

    @MessageMapping("/ocorrencia/ciencia")
    public void darCiencia(@Payload OcorrenciaDTO dto) {
        ocorrenciaService.confirmarCiencia(dto);
    }
}
