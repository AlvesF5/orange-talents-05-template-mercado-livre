package br.com.mercadozup.mercadolivre.finalizarcompra;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotaFiscal implements EventoCompraSucesso {
	
	public void processa(Compra compra)  {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, Object> request = Map.of("idCompra", compra.getId(), "idComprador",compra.getComprador().getId());
		
		restTemplate.postForEntity("http://localhost:8080/notas-fiscais", request, String.class);
		
	}

}
