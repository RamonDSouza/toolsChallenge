package com.toolsChallenge.service.testDadosMock;

import java.util.Optional;

import com.toolsChallenge.model.Transacao;

public class TransacaoDadosMock {
	
	public Optional<Transacao> cria(Integer id) {
		
		Transacao transacao = new Transacao();
        transacao.setCartao("550******5250");
        transacao.setDescricao(new DescricaoDadosMock().cria().get());
        transacao.setFormaPagamento(new FormaPagamentoDadosMock().cria().get());
        transacao.setId(id);
        
		return Optional.of(transacao);
	}

	
public Optional<Transacao> criaEscolhendoStatus(Integer id, String status) {
		
	Transacao transacao = new Transacao();
    transacao.setCartao("550******5250");
    transacao.setDescricao(new DescricaoDadosMock().cria().get());
    transacao.setFormaPagamento(new FormaPagamentoDadosMock().cria().get());
    transacao.setId(id);
    
	return Optional.of(transacao);
	}
}
