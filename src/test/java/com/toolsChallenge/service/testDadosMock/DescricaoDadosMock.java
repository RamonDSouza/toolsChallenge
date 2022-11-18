package com.toolsChallenge.service.testDadosMock;

import java.util.Optional;

import com.toolsChallenge.model.DescricaoTransacao;

public class DescricaoDadosMock {
	public Optional<DescricaoTransacao> cria() {
		
		DescricaoTransacao descricao = new DescricaoTransacao();
	
		descricao.setCodigoAutorizacao("52010010");
        descricao.setDataHora("17/11/2022 15:30:0");
        descricao.setEstabelecimento("Pet Shop");
        descricao.setId(1);
        descricao.setNsu("520030");
        descricao.setStatus("AUTORIZADO");
        descricao.setValor("300");
		
		return Optional.of(descricao);
	}
	
public Optional<DescricaoTransacao> criaEscolhendoStatus(String status) {
		
		DescricaoTransacao descricao = new DescricaoTransacao();
	
		descricao.setCodigoAutorizacao("52010010");
		descricao.setDataHora("17/11/2022 15:30:0");
	    descricao.setEstabelecimento("Pet Shop");
        descricao.setId(1);
        descricao.setNsu("150362");
        descricao.setStatus(status);
        descricao.setValor("50");
		
		return Optional.of(descricao);
	}

}