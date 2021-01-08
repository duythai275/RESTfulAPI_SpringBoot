package HHA.RESTful.API.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import HHA.RESTful.API.service.UserService;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService service;
	
	@Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
		
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if ( header != null && header.startsWith("Bearer ") ) {
			String token = header.split(" ")[1];
			String username = jwtUtil.getUsername(token);
			
			if ( username != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
				UserPrincipal userDetail = (UserPrincipal) service.loadUserByUsername(username);
				
				if ( jwtUtil.validateToken(token, userDetail) ) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
	                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		}
		chain.doFilter(request, response);
	}
}
