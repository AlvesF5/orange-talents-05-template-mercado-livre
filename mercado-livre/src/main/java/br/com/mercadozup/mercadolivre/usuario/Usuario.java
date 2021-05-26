package br.com.mercadozup.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String login;
	@Column(nullable=false)
	

	private String senha;
	private LocalDateTime instanteCadastro = LocalDateTime.now();
	
	
	
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
	
	
	
	
	
}
