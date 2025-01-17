package br.com.mercadozup.mercadolivre.usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	private LocalDateTime instanteCadastro = LocalDateTime.now();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	
	
	@Deprecated
	public Usuario() {
	}


	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}


	public Long getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getSenha() {
		return senha;
	}


	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}


	@Override
	public String getPassword() {
	
		return this.senha;
	}


	@Override
	public String getUsername() {

		return this.login;
	}


	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}


	@Override
	public boolean isEnabled() {

		return true;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + "]";
	}
	
	
	
	
	
	
	
}
