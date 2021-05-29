package br.com.mercadozup.mercadolivre.email;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

@Component
public class EnviadorEmail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void enviarEmail(MensagemEmail mensagem) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mensagem.getRemetente());
		simpleMailMessage.setTo(mensagem.getDestinatario());
		simpleMailMessage.setSubject(mensagem.getAssunto());
		simpleMailMessage.setText(mensagem.getCorpo());
		
		javaMailSender.send(simpleMailMessage);
	}

}
