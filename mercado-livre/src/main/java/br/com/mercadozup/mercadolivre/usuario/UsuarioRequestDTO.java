package br.com.mercadozup.mercadolivre.usuario;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



public class UsuarioRequestDTO {
	
	@Email @NotBlank @NotNull 
	@UniqueValue(domainClass = Usuario.class, fieldName = "login")
	private String login;
	@NotBlank @NotNull @Length(min=6)
	private String senha;
	
	
	public Usuario transformarParaUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
		
		StringBuilder sb = new StringBuilder();
		
		for(byte b : messageDigest) {
			sb.append(String.format("%02X", 0xFF & b));
		}
		
		String senhaHex = sb.toString();
		
		senha = senhaHex;
		
		return new Usuario(login,senha);
	}

	
	


	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	
	
	
	
}
