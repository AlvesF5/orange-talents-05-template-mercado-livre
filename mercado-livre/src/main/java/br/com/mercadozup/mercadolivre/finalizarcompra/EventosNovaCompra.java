package br.com.mercadozup.mercadolivre.finalizarcompra;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mercadozup.mercadolivre.email.DisparadorDeEmail;

@Component
public class EventosNovaCompra {
	
	private Set<EventoCompraSucesso> eventosCompraSucesso;
	
	@Autowired
	private DisparadorDeEmail disparadorDeEmail;

	public void processa(Compra compra) {
		
		if(compra.processadaComSucesso()) {
			
			eventosCompraSucesso.forEach(evento -> evento.processa(compra));
			
		}else
			disparadorDeEmail.dispararEmailFalhaCompra(compra);
		
	}

		
}
