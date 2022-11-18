package com.toolsChallenge.service;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.exception.TransacaoNaoEncontradaException;
import com.toolsChallenge.model.Transacao;
import com.toolsChallenge.model.enums.StatusTransacao;
import com.toolsChallenge.repository.TransacaoRepository;
import com.toolsChallenge.service.testDadosMock.TransacaoDadosMock;

@ContextConfiguration(classes = {EstornoService.class})
@ExtendWith(SpringExtension.class)
class EstornoServiceTest {
	
	
	@Autowired 
	private EstornoService estornoService;
	
	@MockBean
	private TransacaoService transacaoService;
	
	@MockBean
	private TransacaoRepository transacaoRepository;
	
    
    private static final Integer ID = 1;
	
	/**
	 * Consulta pelo ID 
	 */
	  @Test
	    void testConsultaPorIdRetornaDTO() {
	    	
	    	Transacao result = new TransacaoDadosMock().cria(ID).get();
	    	
	        when(this.transacaoService.consultaPorId((Integer) any())).thenReturn(result);
	        
	        TransacaoDTO.Retorno resultTest = this.estornoService.consultaPorIdRetornaDTO(ID).getTransacao();
	        
	        assertSame(result.getFormaPagamento(), resultTest.getFormaPagamento());
	        assertSame(result.getDescricao(), resultTest.getDescricao());
	        verify(this.transacaoService).consultaPorId((Integer) any());
	    }
	
	
	    /**
	     * Consulta por ID e transação não será encontrada. 
	     */
	    @Test
	    void testSeExcecaoLancadaTransacaoNaoEncontradaException() {
	        when(this.transacaoService.consultaPorId((Integer) any())).thenThrow(new TransacaoNaoEncontradaException("Erro"));
	        assertThrows(TransacaoNaoEncontradaException.class, () -> this.estornoService.consultaPorIdRetornaDTO(ID));
	        verify(this.transacaoService).consultaPorId((Integer) any());
	    }
	    
	    
	    
	    /**
	     * estornarTransacao(Integer)}
	     */
	    @Test
	    void testEstornarTransacao() {
	        
	        Transacao transacao = new TransacaoDadosMock().cria(ID).get();

	        when(this.transacaoRepository.save((Transacao) any())).thenReturn(transacao);

	        when(this.transacaoService.consultaPorId((Integer) any())).thenReturn(transacao);

	        TransacaoDTO.Retorno resultadoUnderTest = this.estornoService.estornarTransacao(ID).getTransacao();
	        
	        assertEquals(StatusTransacao.CANCELADO.toString(), resultadoUnderTest.getDescricao().getStatus());
	        verify(this.transacaoRepository).save((Transacao) any());
	        verify(this.transacaoService).consultaPorId((Integer) any());
	    }

	

}
