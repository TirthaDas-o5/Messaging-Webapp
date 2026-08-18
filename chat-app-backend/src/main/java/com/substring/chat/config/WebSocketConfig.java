package com.substring.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        // /topic/messages
        // test/messages
        config.setApplicationDestinationPrefixes("/app");
        // /app/chat
        // server-side: @MessagingMapping("/chat")

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // when client subscribe
        // here a connection would be established
        registry.addEndpoint("/chat") // connection establishment
            .setAllowedOrigins("http://localhost:3000")
            .withSockJS();// provides alternate connection
    }
    // chat endpoint per connection will be established
}
