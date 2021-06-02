package br.com.mercadozup.mercadolivre.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.mercadozup.mercadolivre.usuario.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private GerenciadorDeToken gerenciadorToken;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AutenticaUsuarioNoBanco autenticacaUsuario;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
    
	//Configuções de autenticação de usuário (Fazer login)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaUsuario).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configurações de autorização (Liberar ou bloquear acesso a algum recurso)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.antMatchers(HttpMethod.POST,"/notas-fiscais").permitAll()
		.antMatchers(HttpMethod.POST,"/ranking").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(gerenciadorToken, usuarioRepository), UsernamePasswordAuthenticationFilter.class);

	}
	
	//Configurações de recursos estáicos (imagens, css, javascript)
	@Override
	public void configure(WebSecurity web) throws Exception {
	
	}
	
	
	
}
