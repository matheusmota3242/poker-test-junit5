package com.m2g2.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.m2g2.model.Carta;
import com.m2g2.model.Mao;

public class ClassificacaoHelper {

	public static boolean isStraight(Mao mao) {
		int[] cartasOrdenadas = mao.getStreamComValorInteiroDasCartas()
				.sorted()
				.mapToInt(Integer::intValue)
				.toArray();
		if (IntStream.range(0, cartasOrdenadas.length - 1).allMatch(i -> cartasOrdenadas[i + 1] - cartasOrdenadas[i] == 1)) {
			return true;
		}
		
		return cartasOrdenadas[0] == 1 && IntStream.range(1, cartasOrdenadas.length - 1).allMatch(i -> cartasOrdenadas[i + 1] - cartasOrdenadas[i] == 1);	
	}
	
	public static boolean isFlush(Mao mao) {
		Map<NaipeCarta, Long> contagemPorNaipe = mao.getCartas().stream().map(Carta::getNaipe)
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		return contagemPorNaipe.values().stream().anyMatch(contagem -> contagem == 5);
	}
}
