package br.com.mercadozup.mercadolivre.finalizarcompra;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Ranking  implements EventoCompraSucesso{

	public void processa(Compra compra) {
	
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, Object> request = Map.of("idCompra", compra.getId(),"idDonoProduto",compra.getProdutoComprado().getIdDonoProduto());
		
		restTemplate.postForEntity("http://localhost:8080/ranking", request, String.class);
	}

}
