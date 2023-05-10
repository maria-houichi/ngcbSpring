package ngcb.app.ngcb.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class AuthenticationResponse {

	public AuthenticationResponse(String token) {
		this.token = token;
	}

	private String token ;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
