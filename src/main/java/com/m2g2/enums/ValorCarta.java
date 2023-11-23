package com.m2g2.enums;

public enum ValorCarta {

	A(1),
	N2(2),
	N3(3),
	N4(4),
	N5(5),
	N6(6),
	N7(7),
	N8(8),
	N9(9),
	N10(10),
	J(11),
	Q(12),
	K(13);
	
	ValorCarta(Integer valor) {
		this.valor = valor;
	}

	private Integer valor;
	
	public Integer getValor() {
		return valor;
	}
	
}
