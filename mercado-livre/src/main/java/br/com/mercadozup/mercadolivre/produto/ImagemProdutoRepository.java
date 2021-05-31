package br.com.mercadozup.mercadolivre.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long>{
	List<ImagemProduto> findByProdutoId(Long id);
}
