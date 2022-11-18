package com.toolsChallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Descricao")
public class DescricaoTransacao {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;

	@Column(name="valor")
	private String valor;

	@Column(name="dataHora")
	private String dataHora;

	@Column(name="estabelecimento")
	private String estabelecimento;

	@Column(name="nsu")
	private String nsu;

	@Column(name="codigo_autorizacao")
	private String codigoAutorizacao;

	@Column(name="status")
	private String status;

	public DescricaoTransacao() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getNsu() {
		return nsu;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
	}

	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public void setCodigoAutorizacao(String codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




}
