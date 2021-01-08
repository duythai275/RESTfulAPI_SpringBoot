package HHA.RESTful.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import HHA.RESTful.API.domain.User;
import HHA.RESTful.API.security.AuthRequest;
import HHA.RESTful.API.security.JwtUtil;
import HHA.RESTful.API.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
    private JwtUtil jwtUtil;
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public void register (@RequestBody User user) {
		service.saveUser(user);
	}
	
	@PostMapping("/login")
	public String login (@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
