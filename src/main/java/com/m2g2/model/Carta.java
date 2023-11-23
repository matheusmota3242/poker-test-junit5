package com.m2g2.model;

import com.m2g2.enums.NaipeCarta;
import com.m2g2.enums.ValorCarta;

public class Carta {
	
	private ValorCarta valor;
	
	private NaipeCarta naipe;

	public ValorCarta getValor() {
		return valor;
	}

	public void setValor(ValorCarta valor) {
		this.valor = valor;
	}

	public NaipeCarta getNaipe() {
		return naipe;
	}

	public void setNaipe(NaipeCarta naipe) {
		this.naipe = naipe;
	}

}
