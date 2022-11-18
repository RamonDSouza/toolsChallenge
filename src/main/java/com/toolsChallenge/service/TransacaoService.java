package com.toolsChallenge.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.exception.TransacaoAutorizadaException;
import com.toolsChallenge.exception.TransacaoNaoEncontradaException;
import com.toolsChallenge.model.Transacao;
import com.toolsChallenge.repository.TransacaoRepository;
import com.toolsChallenge.validation.ValidarPagamento;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	//Consultar Transação(Pagamento) pelo id
	public Transacao consultaPorId(Integer id) {

		Optional<Transacao> transacao = transacaoRepository.findById(id);

		if (transacao.isEmpty()) {
			throw new TransacaoNaoEncontradaException("Transacao do id: " + id + " não foi encontrada. Tente novamente!");
		}
		return transacao.get();
}
	//DTO para retornar apenas o que foi pedido no documento
	public TransacaoDTO consultaPorIdRetornaDTO(Integer id) {
		//DTO convertido apenas com os dados que foram pedidos
		return TransacaoDTO.converterTransacaoParaDTO(this.consultaPorId(id));
	}

	//Listar todas as transações
	public List<TransacaoDTO> consultaTodos() {

		var lista = transacaoRepository.findAll();

		if (lista.isEmpty()) {
			throw new TransacaoNaoEncontradaException("Não foram encontradas transações.");
		}

		List<TransacaoDTO> listaDTO = new ArrayList<>();

		for (Transacao entidade : lista) {
			listaDTO.add(TransacaoDTO.converterTransacaoParaDTO(entidade));
		}
		return listaDTO;

	}


//Solicitar um Pagamento / Transação
public TransacaoDTO solicitaPagamento(TransacaoDTO dto) {

		try {
			//Fiz uma Interface ValidarPagamento para fazer toda parte de regras de negócio e passo a minha DTO. 
			ValidarPagamento.validaSeJaAutorizada(dto);
			ValidarPagamento.simuladorAutorizacaoPagamento(dto);
			//Salvando os dados da Classe Transacao com a minha DTO convertidada. 
			Transacao transacao = TransacaoDTO.converterTransacaoDTOParaEntidade(dto);
			//Salvando 
			var entidadeSalva = transacaoRepository.save(transacao);
			
			return TransacaoDTO.converterTransacaoParaDTO(entidadeSalva);

		} catch (TransacaoAutorizadaException e) {
        	throw new TransacaoAutorizadaException(e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
        	throw new RuntimeException("Erro inesperado.");
		}
	}


}
