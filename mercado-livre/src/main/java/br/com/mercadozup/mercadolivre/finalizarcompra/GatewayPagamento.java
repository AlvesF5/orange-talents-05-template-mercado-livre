package br.com.mercadozup.mercadolivre.finalizarcompra;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public enum GatewayPagamento {
	PAGSEGURO{
		
		String criaUrlRetorno(Compra compra, UriComponentsBuilder  uriComponentsBuilder) {
			
			UriComponents urlRetornoPagseguro = uriComponentsBuilder
				.path("/retorno-pagseguro/{id}")
				.buildAndExpand(compra.getId().toString());
			
			return "pagseguro.com/" + compra.getId() + "?redirectUrl" + urlRetornoPagseguro;
		
		
		}
	}, PAYPAL{
		String criaUrlRetorno(Compra compra, UriComponentsBuilder  uriComponentsBuilder) {
			
			UriComponents urlRetornoPagseguro = uriComponentsBuilder
				.path("/retorno-paypal/{id}")
				.buildAndExpand(compra.getId().toString());
			
			return "paypal.com/" + compra.getId() + "?redirectUrl" + urlRetornoPagseguro;
	};
	
}
}