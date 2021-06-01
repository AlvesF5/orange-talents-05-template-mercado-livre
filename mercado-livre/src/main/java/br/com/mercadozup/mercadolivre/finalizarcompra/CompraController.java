package br.com.mercadozup.mercadolivre.finalizarcompra;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadozup.mercadolivre.email.DisparadorDeEmail;
import br.com.mercadozup.mercadolivre.produto.Produto;
import br.com.mercadozup.mercadolivre.produto.ProdutoRepository;
import br.com.mercadozup.mercadolivre.usuario.Usuario;


@RestController
@RequestMapping("novacompra")
public class CompraController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	private GatewayPagamento gateway;
	
	@Autowired
	private DisparadorDeEmail disparadorEmail;
	
	@PostMapping
	public ResponseEntity<?> comprarProduto(@RequestBody @Valid CompraRequest compra, @AuthenticationPrincipal Usuario comprador) throws BindException{
		Produto produtoComprado = produtoRepository.findById(compra.getIdProduto()).get();
		
		int quantidade = compra.getQuantidade();
		
		gateway = compra.getGateway();
		
		boolean abateuEstoque = produtoComprado.abateQuantidadeEstoque(compra.getQuantidade());
		
		if(abateuEstoque) {
			Usuario compradorProduto = comprador;
			Compra novaCompra = new Compra(produtoComprado, quantidade, compradorProduto, gateway);
			compraRepository.save(novaCompra);
			
			disparadorEmail.dispararEmailCompra(novaCompra);
			
			
			
			if(gateway.equals(GatewayPagamento.PAGSEGURO)) {
				return ResponseEntity.status(HttpStatus.FOUND).body("pageseguro.com/" + novaCompra.getId() + "?redirectUrl=/retorno-pagseguro") ;
			}else
				
			    return ResponseEntity.status(HttpStatus.FOUND).body("paypal.com/" + novaCompra.getId() + "?redirectUrl=/retorno-paypal") ;
			
		}
		
		BindException estoqueInsuficiente = new BindException(compra, "compraRequest");
		
		estoqueInsuficiente.reject(null, "Produto sem estoque! Não foi possível realizar essa compra.");
		
		throw estoqueInsuficiente;
	
		
	}

}
