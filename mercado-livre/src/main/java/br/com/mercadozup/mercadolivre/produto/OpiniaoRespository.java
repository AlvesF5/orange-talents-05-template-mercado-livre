package br.com.mercadozup.mercadolivre.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OpiniaoRespository extends JpaRepository<Opiniao,Long> {
	
	List<Opiniao> findByProdutoId(Long idProduto);
}
