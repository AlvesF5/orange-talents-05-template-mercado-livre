package br.com.mercadozup.mercadolivre.finalizarcompra;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechamentoCompraController {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private NotaFiscal notaFiscal;
	
	@Autowired
	private Ranking ranking;
	@Autowired
	private EventosNovaCompra eventosNovaCompra;
	
	@PostMapping(value = "/retorno-pagseguro/{id}")
	public String processamentoPagSeguro(@PathVariable("id") Long idCompra, @Valid RetornoPagseguroRequest retornoPagseguro) {
		
		return processaCompra(idCompra, retornoPagseguro);
		
	}
	
	
	@PostMapping(value = "/retorno-paypal/{id}")
	public String processamentoPayPal(@PathVariable("id") Long idCompra, @Valid RetornoPayPal retornoPaypal) {
		
		return processaCompra(idCompra, retornoPaypal);
		
	}
	
	
	
	private String processaCompra(Long idCompra, RetornoGatewayPagamento retornaGatewayPagamento) {
		
		Compra compra = compraRepository.findById(idCompra).get();
		
		compra.adicionaTransacao(retornaGatewayPagamento);
		
		compraRepository.flush();
		
		
		eventosNovaCompra.processa(compra);
		
		return compra.toString();
		
	}
	
	
}
