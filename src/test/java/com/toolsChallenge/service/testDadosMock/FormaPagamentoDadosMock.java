package com.toolsChallenge.service.testDadosMock;

import java.util.Optional;

import com.toolsChallenge.model.FormaPagamento;

public class FormaPagamentoDadosMock {
	public Optional<FormaPagamento> cria() {
		
		FormaPagamento formaPagamento = new FormaPagamento();
	
		formaPagamento.setId(1);
        formaPagamento.setParcelas("5");
        formaPagamento.setTipo("AVISTA");
		
		return Optional.of(formaPagamento);
	}
}
