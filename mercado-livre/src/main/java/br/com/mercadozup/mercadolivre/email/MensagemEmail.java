package br.com.mercadozup.mercadolivre.email;



public class MensagemEmail {
	
	private String remetente;
	
	private String destinatario;
	
	private String assunto;
	
	private String corpo;
	
	
	

	

	public MensagemEmail(String remetente, String destinatario, String assunto, String corpo) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.corpo = corpo;
	}

	public String getRemetente() {
		return remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getCorpo() {
		return corpo;
	}
	
	
	
	
	
}
