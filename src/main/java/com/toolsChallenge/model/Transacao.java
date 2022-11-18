package com.toolsChallenge.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transacao")
//Classe principal da aplicação, decidi separar a chamada em 3 classes para facilitar a transação de dados pela aplicação
public class Transacao {
	private String cartao;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "DescricaoId")
	private DescricaoTransacao descricao;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "FormaPagamentoId")
	private FormaPagamento formaPagamento;


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

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}



}
