package com.m2g2.model.builder;

import com.m2g2.enums.NaipeCarta;
import com.m2g2.enums.ValorCarta;
import com.m2g2.model.Carta;

public class CartaBuilder {

	private ValorCarta valor;
	private NaipeCarta naipe;
	
	public static CartaBuilder umaCarta() {
		return new CartaBuilder();
	}
	
	public CartaBuilder comValor(ValorCarta valor) {
		this.valor = valor;
		return this;
	}
	
	public CartaBuilder comNaipe(NaipeCarta naipe) {
		this.naipe = naipe;
		return this;
	}
	
	public Carta build() {
		Carta carta = new Carta();
		carta.setValor(valor);
		carta.setNaipe(naipe);
		return carta;
	}
	
}
