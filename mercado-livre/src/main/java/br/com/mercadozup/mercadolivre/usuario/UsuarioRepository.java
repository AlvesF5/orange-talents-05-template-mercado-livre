package br.com.mercadozup.mercadolivre.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	
	Optional<Usuario> findByLogin(String login);
}
