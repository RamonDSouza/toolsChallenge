package com.toolsChallenge.model.enums;

import com.toolsChallenge.exception.ParametroInvalidoException;

public enum FormaPagamento {


	AVISTA("AVISTA", "Pagamento a vista"), PARCELADO_LOJA("PARCELADO LOJA", "Parcelamento realizado pela Loja"),
	PARCELADO_EMISSOR("PARCELADO EMISSOR", "Parcelamento realizado pelo emissor");

	private String descricao;

	private String value;

	FormaPagamento(String value, String descricao) {

		this.value = value;
		this.descricao = descricao;
	}

	public static FormaPagamento getNome(String codigo) {
		for (FormaPagamento tf : values()) {
			if (tf.value.equals(codigo)) {
				return tf;
			}
		}
		throw new ParametroInvalidoException(
				"Tipo Forma Pagamento informado inválido");
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
