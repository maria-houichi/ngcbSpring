package ngcb.app.ngcb.config;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.util.HtmlUtils;
import ngcb.app.ngcb.model.Message;
import ngcb.app.ngcb.model.ResponseMessage;
import ngcb.app.ngcb.model.UserHandshakeHandler;
import ngcb.app.ngcb.service.NotificationService;

//@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig //implements WebSocketMessageBrokerConfigurer {
{
//    @Override
//    public void configureMessageBroker(final MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/topic");
//        registry.setApplicationDestinationPrefixes("/ws");
//    }
//
//    @Override
//    public void registerStompEndpoints(final StompEndpointRegistry registry) {
//        registry.addEndpoint("/our-websocket")
//                .setHandshakeHandler(new UserHandshakeHandler())
//                .withSockJS();
//    }
	
	
	
	
	
	
	
	
	
	
	
//	
//    private WebSocketProperties properties;
//    
//    
//	@Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//		
//        registry.enableSimpleBroker(properties.getTopicPrefix());
//        registry.setApplicationDestinationPrefixes(properties.getApplicationPrefix());
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint(properties.getEndpoint()).setAllowedOrigins(properties.getAllowedOrigins()).withSockJS();
//    }
}
