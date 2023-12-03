package com.m2g2.model;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.m2g2.enums.Classificacao;

public class DoisParesHandler extends AbstractHandler {
	
	public DoisParesHandler() {
		classificacao = Classificacao.DOIS_PARES;
		proximo = new ParHandler();
	}

	@Override
	public Classificacao classificar(Mao mao) {
		Map<Integer, Long> contagemPorValor = mao
				.getStreamComValorInteiroDasCartas()
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
		
		int cont = 0;
		for (Entry<Integer, Long> entry : contagemPorValor.entrySet()) {
			if (entry.getValue() == 2) {
				cont++;
				if (cont == 2) {
					return classificacao;
				}
			}	
		}
		return proximo.classificar(mao);
	}

}
