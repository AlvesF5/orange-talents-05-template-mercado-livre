package br.com.mercadozup.mercadolivre.finalizarcompra;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutrosSistemasController {
	
	@PostMapping(value="/notas-fiscais")
	public void criaNota(@Valid @RequestBody NovaCompraNFRequest request) throws InterruptedException{
		System.out.println("Criando nota: "+request);
		Thread.sleep(150);
	}
	
	@PostMapping(value="/ranking")
	public void ranking(@Valid @RequestBody RankingNovaCompraRequest request) throws InterruptedException{
		System.out.println("Criando ranking: "+request);
		Thread.sleep(150);
	}

}
