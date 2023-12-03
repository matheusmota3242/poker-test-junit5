package com.m2g2.model;

import java.util.Map;
import java.util.stream.Collectors;

import com.m2g2.enums.Classificacao;

public class FullHouseHandler extends AbstractHandler {
	
	public FullHouseHandler() {
		this.classificacao = Classificacao.FULL_HOUSE;
		this.proximo = new FlushHandler();
	}

	@Override
	public Classificacao classificar(Mao mao) {
		Map<Integer, Long> contagemPorValor = mao
				.getStreamComValorInteiroDasCartas()
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
		
		if (contagemPorValor.values().stream().anyMatch(contagem -> contagem == 3)
				&& contagemPorValor.values().stream().anyMatch(contagem -> contagem == 2)) {
			return classificacao;
		}
		return proximo.classificar(mao);
	}

}
