package com.toolsChallenge.service.testDadosMock;

import java.util.Optional;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.model.Transacao;

public class TransacaoDTODadosMock {
	
	public Optional<TransacaoDTO> cria(Integer id) {
		
		Transacao transacao = new TransacaoDadosMock().cria(id).get();
		
		TransacaoDTO dto = new TransacaoDTO();
		
		dto.setTransacao(dto.new Retorno(transacao.getCartao(), transacao.getId(), transacao.getDescricao(), transacao.getFormaPagamento()));
		
		dto.getTransacao().getDescricao().setStatus(null);
		
		return Optional.of(dto);
	}

}
