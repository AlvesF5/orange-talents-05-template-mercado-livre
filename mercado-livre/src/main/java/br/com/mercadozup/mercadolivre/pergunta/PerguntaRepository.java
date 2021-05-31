package br.com.mercadozup.mercadolivre.pergunta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PerguntaRepository extends JpaRepository<Pergunta,Long>{
	List<Pergunta> findByProdutoId(Long id);
}
