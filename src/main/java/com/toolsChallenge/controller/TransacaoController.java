package com.toolsChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolsChallenge.dto.TransacaoDTO;
import com.toolsChallenge.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {


	@Autowired
	private TransacaoService service;



	@GetMapping("/consultarTodos")
	public ResponseEntity<List<TransacaoDTO>> consultaTodos()
	{
		return ResponseEntity.ok(service.consultaTodos());
	}
	
	@GetMapping("/consultarPorId")
	public ResponseEntity<TransacaoDTO> consultaPorId(Integer id) 
	{		
		return ResponseEntity.ok(service.consultaPorIdRetornaDTO(id));
	}

	@PostMapping("/solicitar-transacao")
	public ResponseEntity<TransacaoDTO> solicitaPagamento(@RequestBody TransacaoDTO dto)
	{
		return ResponseEntity.ok(service.solicitaPagamento(dto));
	}



}
