package br.com.mercadozup.mercadolivre.finalizarcompra;

import javax.validation.constraints.NotNull;

public class RetornoPagseguroRequest implements RetornoGatewayPagamento {
	
	@NotNull
	private String idTransacao;
	@NotNull
	private StatusRetornoPagseguro status;
	

	public RetornoPagseguroRequest(@NotNull String idTransacao, StatusRetornoPagseguro status) {
		this.idTransacao = idTransacao;
		this.status = status;
	}


	@Override
	public String toString() {
		return "RetornoPagseguroRequest [idTransacao=" + idTransacao + ", status=" + status + "]";
	}


	public Transacao toTransacao(Compra compra) {
		// TODO Auto-generated method stub
		return new Transacao(status.normaliza(),idTransacao,compra);
	}
	
	
	
	
}
