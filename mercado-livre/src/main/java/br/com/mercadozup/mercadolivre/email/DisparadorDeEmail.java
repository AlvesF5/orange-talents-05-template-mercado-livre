package br.com.mercadozup.mercadolivre.email;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import br.com.mercadozup.mercadolivre.finalizarcompra.Compra;
import br.com.mercadozup.mercadolivre.pergunta.Pergunta;


@Component
public class DisparadorDeEmail {
	
	public  void dispararEmail(Pergunta pergunta) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DisparadorDeEmail.class.getPackage().getName());
		
		
		EnviadorEmail enviador = applicationContext.getBean(EnviadorEmail.class);
		
		
		
		enviador.enviarEmail(new MensagemEmail("Nova Pergunta Recebida<mercadolivrezup@gmail.com>","<"+ pergunta.getProduto().getDonoProduto().getLogin() +">", "" + "Título da Pergunta: "+ pergunta.getTitulo() +""," "+ " Cliente: "+ pergunta.getDonoPergunta().getLogin() + " Produto: "+ pergunta.getProduto().getNome() + " " + "Pergunta:"+ pergunta.getDescricao() +""));
		
		applicationContext.close();
		
		System.out.println("E-mail enviado com sucesso");
	}
	
	public  void dispararEmailCompra(Compra compra) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DisparadorDeEmail.class.getPackage().getName());
		
		
		EnviadorEmail enviador = applicationContext.getBean(EnviadorEmail.class);
		
		
		
		enviador.enviarEmail(new MensagemEmail("Novo Pedido Recebido<mercadolivrezup@gmail.com>", compra.getProdutoComprado().getDonoProduto().getLogin(), "Informações do Pedido", compra.toString()));
		
		applicationContext.close();
		
		System.out.println("E-mail enviado com sucesso");
	}
	
	public  void dispararEmailFalhaCompra(Compra compra) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DisparadorDeEmail.class.getPackage().getName());
		
		
		EnviadorEmail enviador = applicationContext.getBean(EnviadorEmail.class);
		
		
		
		enviador.enviarEmail(new MensagemEmail("Compra Nao efetuada! <mercadolivrezup@gmail.com>", compra.getComprador().getLogin(), "Informações da compra", compra.toString()));
		
		applicationContext.close();
		
		System.out.println("E-mail enviado com sucesso");
	}
}
