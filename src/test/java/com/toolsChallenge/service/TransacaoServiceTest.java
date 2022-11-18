package com.toolsChallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.exception.TransacaoAutorizadaException;
import com.toolsChallenge.exception.TransacaoNaoEncontradaException;
import com.toolsChallenge.model.Transacao;
import com.toolsChallenge.model.enums.StatusTransacao;
import com.toolsChallenge.repository.TransacaoRepository;
import com.toolsChallenge.service.testDadosMock.TransacaoDTODadosMock;
import com.toolsChallenge.service.testDadosMock.TransacaoDadosMock;

@ContextConfiguration(classes = {TransacaoService.class})
@ExtendWith(SpringExtension.class)
class TransacaoServiceTest {
	
    @Autowired
    private TransacaoService transacaoService;

    @MockBean
    private TransacaoRepository transacaoRepository;

    private static final Integer ID = 1;
    
    /**
     * consulta toda as transações/pagamentos()
     */
    @Test
    void testConsultaTodos() {
    	
    	Transacao transacao = new TransacaoDadosMock().cria(ID).get();

        ArrayList<Transacao> transacaoList = new ArrayList<>();
        transacaoList.add(transacao);
        
        when(this.transacaoRepository.findAll()).thenReturn(transacaoList);
        
        List<TransacaoDTO> actualConsultaTodosResult = this.transacaoService.consultaTodos();
        
        assertEquals(1, actualConsultaTodosResult.size());
        verify(this.transacaoRepository).findAll();
    }

    /**
     * consulta pelo Id Retornando TransacaoDTO
     */
    @Test
    void testSeExcecaoLancadaTransacaoNaoEncontradaException() {
        when(this.transacaoRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(TransacaoNaoEncontradaException.class, () -> this.transacaoService.consultaPorIdRetornaDTO(ID));
        verify(this.transacaoRepository).findById((Integer) any());
    }

    /**
     * Consulta simples pelo ID
     */
    @Test
    void testConsultaPorId() {
        
    	Transacao resultadoEsperado = new TransacaoDadosMock().cria(ID).get();
    	
        Optional<Transacao> optionalDe = Optional.of(resultadoEsperado);
        when(this.transacaoRepository.findById((Integer) any())).thenReturn(optionalDe);
        assertSame(resultadoEsperado, this.transacaoService.consultaPorId(ID));
        verify(this.transacaoRepository).findById((Integer) any());
    }

    /**
     * Teste para consultar pelo ID e retornar uma excessão quando não for encontrada.
     */
    @Test
    void testParaGerarExcecaoComIdNaoEncontrado() {
        when(this.transacaoRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(TransacaoNaoEncontradaException.class, () -> this.transacaoService.consultaPorId(ID));
        verify(this.transacaoRepository).findById((Integer) any());
    }

    /**
     * Teste para simular uma soliticação de transação.
     */
    @Test
    void testSolicitaTransacao() {
    	
    	Transacao resultadoEsperado = new TransacaoDadosMock().cria(ID).get();
        when(this.transacaoRepository.save((Transacao) any())).thenReturn(resultadoEsperado);
        
        TransacaoDTO transacaoDTO = new TransacaoDTODadosMock().cria(ID).get();
        
        TransacaoDTO.Retorno resultadoUnderTest = this.transacaoService.solicitaPagamento(transacaoDTO).getTransacao();
        
        assertEquals(resultadoEsperado.getCartao(), resultadoUnderTest.getCartao());
        verify(this.transacaoRepository).save((Transacao) any());
    }

    /**
     * Teste para solicitar uma transação e gerar uma excessão de AUTORIZADO. 
     */
    @Test
    void testSolicitarTransacaoRetornarExcessao() {
    	
        TransacaoDTO transacaoDTO = new TransacaoDTODadosMock().cria(ID).get();
        transacaoDTO.getTransacao().getDescricao().setStatus(StatusTransacao.AUTORIZADO.toString());
        
        assertThrows(TransacaoAutorizadaException.class, () -> this.transacaoService.solicitaPagamento(transacaoDTO));
    }
    
    /**
     * Testes para gerar uma Excessao
     */
    @Test
    void testSolicitaTransacaoSeExcecaoLancadaRuntimeException1() {
    	assertThrows(RuntimeException.class, () -> this.transacaoService.solicitaPagamento(new TransacaoDTO()));
    }
    
    @Test
    void testSolicitaTransacaoSeExcecaoLancadaRuntimeException2() {
    	assertThrows(RuntimeException.class, () -> this.transacaoService.solicitaPagamento(null));
    }
}

