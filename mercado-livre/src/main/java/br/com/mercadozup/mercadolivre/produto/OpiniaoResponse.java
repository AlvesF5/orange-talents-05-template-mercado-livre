package br.com.mercadozup.mercadolivre.produto;



import java.util.List;
import java.util.stream.Collectors;

import br.com.mercadozup.mercadolivre.usuario.Usuario;

public class OpiniaoResponse {
	
	private Integer nota;
	private String titulo;
	private String descricao;
	private String donoOpiniao;
	
	public OpiniaoResponse(Opiniao opiniao) {
	
		this.nota = opiniao.getNota();
		this.titulo = opiniao.getTitulo();
		this.descricao = opiniao.getDescricao();
		this.donoOpiniao = opiniao.getDonoOpiniao().getLogin();
	}
	
	
	public static List<OpiniaoResponse> converter(List<Opiniao> opinioes){
		
		return opinioes.stream().map(OpiniaoResponse::new).collect(Collectors.toList());
		
	}


	public Integer getNota() {
		return nota;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public String getDonoOpiniao() {
		return donoOpiniao;
	}


	
	
	
}
