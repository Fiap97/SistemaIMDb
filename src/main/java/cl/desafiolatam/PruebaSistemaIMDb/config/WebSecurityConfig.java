package cl.desafiolatam.PruebaSistemaIMDb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	private UserDetailsService userDetailsService;
	
	/* se crean 2 usuarios en memoria en método configure */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
		//auth.inMemoryAuthentication()
		//.withUser("haskell").password(passwordEncoder().encode("curry")).roles("ADMIN") .and()
		//.withUser("ferris").password(passwordEncoder().encode("crab")).roles("USER");
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.antMatchers("/users/**").hasAuthority("USER")
			.antMatchers("/login").permitAll()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.successHandler(customAuthenticationSuccessHandler)
			.failureUrl("/login?error=true")
			.usernameParameter("email")
			.passwordParameter("password")
			.and()
			.exceptionHandling()
			.accessDeniedPage("/recurso-prohibido");
	}
	
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	 
	@Autowired
	public WebSecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
		this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
	}

	/* Se inicializa bean de encoder de contraseñas */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
}
