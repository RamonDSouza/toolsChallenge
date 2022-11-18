package com.toolsChallenge.validation;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.exception.TransacaoAutorizadaException;
import com.toolsChallenge.model.enums.StatusTransacao;
import com.toolsChallenge.utils.SimuladorAutorizacaoPagamento;

public interface ValidarPagamento {

 static void validaSeJaAutorizada(TransacaoDTO dto) {

		if (dto.getTransacao().getDescricao() != null &&
			dto.getTransacao().getDescricao().getStatus() != null &&
			dto.getTransacao().getDescricao().getStatus().toString()
			.compareToIgnoreCase(StatusTransacao.AUTORIZADO.toString()) == 0) {

			throw new TransacaoAutorizadaException("Transacao já autorizada.");
		}
	}

 static void simuladorAutorizacaoPagamento(TransacaoDTO dto) {

		SimuladorAutorizacaoPagamento.getInstancia();
		Boolean seAutorizado = SimuladorAutorizacaoPagamento.simulaAutorizacao();

		buscaDescricaoPagamento(dto, seAutorizado);

	}

	private static void buscaDescricaoPagamento(TransacaoDTO dto, Boolean seAutorizado) {

		if (seAutorizado) {

			buscaDescricaoAutorizado(dto);

		} else {

			buscaDescricaoNegado(dto);
		}
	}

	private static void buscaDescricaoAutorizado(TransacaoDTO dto) {
		String codigoAutorizacao = SimuladorAutorizacaoPagamento.integerAleatorio().toString();
		dto.getTransacao().getDescricao().setCodigoAutorizacao(codigoAutorizacao);
		dto.getTransacao().getDescricao().setStatus(StatusTransacao.AUTORIZADO.toString());
		String nsu = SimuladorAutorizacaoPagamento.integerAleatorio().toString();
		dto.getTransacao().getDescricao().setNsu(nsu);
	}

	private static void buscaDescricaoNegado(TransacaoDTO dto) {
		String nsu = SimuladorAutorizacaoPagamento.integerAleatorio().toString();
		dto.getTransacao().getDescricao().setNsu(nsu);
		dto.getTransacao().getDescricao().setStatus(StatusTransacao.NEGADO.toString());
	}
}
