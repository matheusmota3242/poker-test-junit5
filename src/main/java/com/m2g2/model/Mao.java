package com.m2g2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.m2g2.enums.Classificacao;

public class Mao {

	private List<Carta> cartas = new ArrayList<>(5);

	public List<Carta> getCartas() {
		return cartas;
	}
	
	public Mao(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Stream<Integer> getStreamComValorInteiroDasCartas() {
		return cartas
		.stream()
		.map(carta -> carta.getValor().getValor());
	}
	
	public Classificacao ranking(Mao mao) {
		//return Arrays.stream(Classificacao.values()).filter(c -> c.classificar(mao)).findFirst().orElse(Classificacao.CARTA_ALTA);
		AbstractHandler handler = new RoyalStraightFlushHandler();
		return handler.classificar(mao);
	}
	
}
