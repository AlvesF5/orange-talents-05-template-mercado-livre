package br.com.mercadozup.mercadolivre.finalizarcompra;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RetornoPayPal implements RetornoGatewayPagamento{
	
	@Min(0) @Max(1)
	private int status;
	
	private String idTransacao;
	
	

	public RetornoPayPal(@Min(0) @Max(1) int status, String idTransacao) {
		this.status = status;
		this.idTransacao = idTransacao;
	}
	
	
	public Transacao toTransacao(Compra compra) {
		
		StatusTransacao statusCalculado = this.status == 0? StatusTransacao.erro:StatusTransacao.sucesso;
		
		return new Transacao(statusCalculado, idTransacao, compra);
	}
	
	

}
