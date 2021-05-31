package br.com.mercadozup.mercadolivre.pergunta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



public class PerguntaResponse {
	
	private String titulo;
	private String descricao;
	private String donoPergunta;
	private LocalDateTime criadaEm = LocalDateTime.now();
	
	
	public PerguntaResponse(Pergunta pergunta) {
		this.titulo=pergunta.getTitulo();
		this.descricao=pergunta.getDescricao();
		this.donoPergunta=pergunta.getDonoPergunta().getLogin();
		this.criadaEm=pergunta.getCriadaEm();
	}
	
	
	
	public static List<PerguntaResponse> converter(List<Pergunta> perguntas){
		
		return perguntas.stream().map(PerguntaResponse::new).collect(Collectors.toList());
		
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDonoPergunta() {
		return donoPergunta;
	}

	public LocalDateTime getCriadaEm() {
		return criadaEm;
	}
	
	
	
}
