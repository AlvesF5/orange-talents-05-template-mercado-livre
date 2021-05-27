package br.com.mercadozup.mercadolivre.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.mercadozup.mercadolivre.usuario.Usuario;
import br.com.mercadozup.mercadolivre.usuario.UsuarioRepository;

@Component
public class AutenticaUsuarioNoBanco implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
		
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados invalidos!");
	}

}
