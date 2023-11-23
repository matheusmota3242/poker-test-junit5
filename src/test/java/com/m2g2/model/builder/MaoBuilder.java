package com.m2g2.model.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.m2g2.model.Carta;
import com.m2g2.model.Mao;

public class MaoBuilder {

	List<Carta> cartas = new ArrayList<>(5);
	
	public static MaoBuilder umaMao() {
		return new MaoBuilder();
	}
	
	public MaoBuilder comCartas(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
		return this;
	}
	
	public Mao build() {
		Mao mao = new Mao(cartas);
		return mao;
	}
}
