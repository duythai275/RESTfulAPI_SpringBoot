package HHA.RESTful.API.security;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}