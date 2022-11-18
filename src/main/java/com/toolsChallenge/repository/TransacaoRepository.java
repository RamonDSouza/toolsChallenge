package com.toolsChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsChallenge.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
