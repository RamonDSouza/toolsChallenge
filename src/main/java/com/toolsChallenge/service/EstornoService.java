package com.toolsChallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.exception.TransacaoCanceladaException;
import com.toolsChallenge.exception.TransacaoNaoEncontradaException;
import com.toolsChallenge.model.Transacao;
import com.toolsChallenge.model.enums.StatusTransacao;
import com.toolsChallenge.repository.TransacaoRepository;

@Service
public class EstornoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private TransacaoService service;


	public TransacaoDTO consultaPorIdRetornaDTO(Integer id) {

		return TransacaoDTO.converterTransacaoParaDTO(this.consultaPorId(id));
	}

	public Transacao consultaPorId(Integer id) {

		return service.consultaPorId(id);
	}
	
	
	//Metodo responsável para fazer o Estorno da Transação.
	public TransacaoDTO estornarTransacao(Integer id) {

		Transacao transacao;
		try {
			transacao = this.consultaPorId(id);

		} catch (TransacaoNaoEncontradaException e) {
			throw new TransacaoNaoEncontradaException("Transacao de id: " + id + " não encontrada.");
		}

		if (transacao.getDescricao().getStatus() == StatusTransacao.CANCELADO.toString()) {
			throw new TransacaoCanceladaException("Transacao de id: " + id + " já cancelada.");
		}

		transacao.getDescricao().setStatus(StatusTransacao.CANCELADO.toString());

		var entidadeSalva = transacaoRepository.save(transacao);

		return TransacaoDTO.converterTransacaoParaDTO(entidadeSalva);
	}

}
