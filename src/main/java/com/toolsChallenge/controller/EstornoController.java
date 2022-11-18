package com.toolsChallenge.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.service.EstornoService;

@RestController
@RequestMapping("/estorno")
public class EstornoController {

	@Autowired
	private EstornoService estornoService;

	@GetMapping("/consultarPorId")
	public ResponseEntity<TransacaoDTO> consultaPorId(Integer id)
	{
		return ResponseEntity.ok(estornoService.consultaPorIdRetornaDTO(id));
	}

	@GetMapping("/estornarTransacao")
	public ResponseEntity<TransacaoDTO> estornarTransacao(Integer id)
	{
		return ResponseEntity.ok(estornoService.estornarTransacao(id));
	}

}
