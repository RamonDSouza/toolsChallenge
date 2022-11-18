package com.toolsChallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;



@Entity
@Table(name = "FormaPagamento")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FormaPagamento {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;

	@Column(name="tipo")
	private String tipo;

	@Column(name="parcelas")
	private String parcelas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}



}
