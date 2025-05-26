package com.senai.projeto_auth_ws.infrastructure.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  //
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {  // websocket = protocolo bidirecional e usa uma conexao , // configuração websocket

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) { // 
        config.enableSimpleBroker("/topic", "/queue"); // topico / fila
        config.setApplicationDestinationPrefixes("/app"); // caminho principal para todos x
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // endpoint principal 
                .setAllowedOriginPatterns("*") // especificação 
                .withSockJS();
    }
}
