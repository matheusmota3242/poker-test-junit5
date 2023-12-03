package com.m2g2.handler;

import java.util.Map;
import java.util.stream.Collectors;

import com.m2g2.enums.Classificacao;
import com.m2g2.model.Mao;

public class ParHandler extends AbstractHandler {

	public ParHandler() {
		classificacao = Classificacao.PAR;
	}
	
	@Override
	public Classificacao classificar(Mao mao) {
		Map<Integer, Long> contagemPorValor = mao
				.getStreamComValorInteiroDasCartas()
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
		
		if (contagemPorValor.values().stream().anyMatch(contagem -> contagem == 2)) {
			return classificacao;
		}
		return Classificacao.CARTA_ALTA;
	}

}
