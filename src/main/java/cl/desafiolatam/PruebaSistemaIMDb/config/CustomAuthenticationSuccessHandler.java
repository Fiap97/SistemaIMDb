package cl.desafiolatam.PruebaSistemaIMDb.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		String roles =  authentication.getAuthorities().toString();
		if (roles.contains("ADMIN")) {
			httpServletResponse.sendRedirect("/admin");
		} else {
			httpServletResponse.sendRedirect("/users");
		}
	}
	

	public String usuarioConectado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		return userName;
	}
	

}


