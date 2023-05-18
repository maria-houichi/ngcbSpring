package ngcb.app.ngcb.model;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class UserHandshakeHandler extends DefaultHandshakeHandler {
//	  private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);
//	  @Override
//	    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
//	        // Extract the username from the bearer token
//	        String bearerToken = extractBearerToken(request);
//	        String username = extractUsernameFromBearerToken(bearerToken);
//
//	        LOG.info("User with username '{}' connected hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhto WebSocket", username);
//
//	        return new UserPrincipal(username);
//	    }
//	   private String extractBearerToken(ServerHttpRequest request) {
//	        // Implement the logic to extract the bearer token from the request.
//	        // This depends on the structure of your API and how the token is included in the request headers.
//	        // Here's an example assuming the token is included in the "Authorization" header:
//	        String authorizationHeader = request.getHeaders().getFirst("Authorization");
//	        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//	            return authorizationHeader.substring(7);
//	        }
//	        return null;
//	    }
//	  
//	  private String extractUsernameFromBearerToken(String bearerToken) {
//	        // Implement the logic to extract the username from the bearer token.
//	        // This depends on how the token is structured and encoded.
//	        // Make sure to handle any token decoding and verification required.
//	        // Here's an example assuming the token is a JWT and the username is stored in the "sub" claim:
//	        try {
//	            // Use the appropriate secret key for token decoding
//	            String secretKey = "5367566B5970337336763979244226452948404D6251655468576D5A71347437";
//
//	            // Parse and verify the token using a JWT library
//	            Claims claims = Jwts.parserBuilder()
//	                    .setSigningKey(secretKey)
//	                    .build()
//	                    .parseClaimsJws(bearerToken)
//	                    .getBody();
//
//	            // Extract the username from the claims
//	            String username = claims.getSubject();
//	            return username;
//	        } catch (Exception e) {
//	            // Handle any exceptions that occur during token parsing or verification
//	            e.printStackTrace();
//	        }
//
//	        return null;
//	    }
	  
	
	
	
	
//	   private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);
//
//	    @Override
//	    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
//	        final String randomId = UUID.randomUUID().toString();
//	        LOG.info("User with ID '{}' openedhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh the page", randomId);
//
//	        return new UserPrincipal(randomId);
//	    }
//	  
}  
		  
		  
		  
		  
		  
		  
		  
		  
		  
//	        // Récupérez votre objet utilisateur à partir des attributs
//	        utilisateur user = (utilisateur) attributes.get("user");
//
//	        // Créez un objet UserPrincipal en utilisant l'utilisateur
//	        UserPrincipal userPrincipal = new UserPrincipal(user);
//	        LOG.info("User with ID '{}' opened the page", userPrincipal);
//	        // Retournez l'objet UserPrincipal comme Principal
//	        return userPrincipal;
