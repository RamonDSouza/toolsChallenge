package com.toolsChallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toolsChallenge.model.DescricaoTransacao;
import com.toolsChallenge.model.FormaPagamento;
import com.toolsChallenge.model.Transacao;

//Optei por fazer uma ÚNICA DTO para aplicação, convertendo Transacao em TransacaoDTO nos Construtores para que eu tenha facilidade
//Em mostrar os dados na tela. 
public class TransacaoDTO {

	@JsonProperty("transacao")
	private Retorno transacao;

	public class Retorno {
		private String cartao;
		private int id;
		private DescricaoTransacao descricao;
		private FormaPagamento formaPagamento;

		public Retorno() {
			super();
		}
		public Retorno(String cartao, int id, DescricaoTransacao descricao, FormaPagamento formaPagamento) {
			super();
			this.cartao = cartao;
			this.id = id;
			this.descricao = descricao;
			this.formaPagamento = formaPagamento;
		}
		public String getCartao() {
			return cartao;
		}
		public void setCartao(String cartao) {
			this.cartao = cartao;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public DescricaoTransacao getDescricao() {
			return descricao;
		}
		public void setDescricao(DescricaoTransacao descricao) {
			this.descricao = descricao;
		}
		public FormaPagamento getFormaPagamento() {
			return formaPagamento;
		}
		public void setFormaPagamento(FormaPagamento formaPagamento) {
			this.formaPagamento = formaPagamento;
		}

	}

//Conversão de DTO para Entidade Model
	public static TransacaoDTO converterTransacaoParaDTO( Transacao transacao ) {

		TransacaoDTO dto = new TransacaoDTO();

		dto.transacao = dto.new Retorno(
				transacao.getCartao(),
				transacao.getId(),
				transacao.getDescricao(),
				transacao.getFormaPagamento());

		return dto;
	}
	
	
//Aqui eu converto minha Entidade Model em DTO.
	public static Transacao converterTransacaoDTOParaEntidade( TransacaoDTO dto ) {

		Transacao transacao = new Transacao();

		transacao.setCartao(dto.getTransacao().getCartao());
		transacao.setDescricao(dto.getTransacao().getDescricao());
		transacao.setFormaPagamento(dto.getTransacao().getFormaPagamento());

		return transacao;
	}

	public TransacaoDTO() {
		super();
	}

	public TransacaoDTO(Retorno transacao) {
		super();
		this.transacao = transacao;
	}

	public Retorno getTransacao() {
		return transacao;
	}

	public void setTransacao(Retorno transacao) {
		this.transacao = transacao;
	}


}
