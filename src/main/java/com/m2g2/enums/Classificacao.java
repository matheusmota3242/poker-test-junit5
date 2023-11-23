package com.m2g2.enums;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.m2g2.model.Carta;
import com.m2g2.model.Mao;

public enum Classificacao {

	ROYAL_STRAIGHT_FLUSH {
		@Override
		public boolean classificar(Mao mao) {
			int[] cartasOrdenadas = mao.getStreamComValorInteiroDasCartas()
					.sorted()
					.mapToInt(Integer::intValue)
					.toArray();
			
			return cartasOrdenadas[4] == ValorCarta.K.getValor() 
					&& cartasOrdenadas[0] == ValorCarta.A.getValor() 
					&& STRAIGHT_FLUSH.classificar(mao);
		}
	},
	STRAIGHT_FLUSH {
		@Override
		public boolean classificar(Mao mao) {
			return STRAIGHT.classificar(mao) && FLUSH.classificar(mao);			
		}
	},
	QUADRA {
		@Override
		public boolean classificar(Mao mao) {
			Map<Integer, Long> contagemPorValor = mao.getStreamComValorInteiroDasCartas()
					.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
			
			return contagemPorValor.values().stream().anyMatch(contagem -> contagem == 4);
		}
	},
	FULL_HOUSE {
		@Override
		public boolean classificar(Mao mao) {
			Map<Integer, Long> contagemPorValor = mao
					.getStreamComValorInteiroDasCartas()
					.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
			
			return contagemPorValor.values().stream().anyMatch(contagem -> contagem == 3)
					&& contagemPorValor.values().stream().anyMatch(contagem -> contagem == 2);
		}
	},
	FLUSH {
		@Override
		public boolean classificar(Mao mao) {
			Map<NaipeCarta, Long> contagemPorNaipe = mao.getCartas().stream().map(Carta::getNaipe)
					.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
			return contagemPorNaipe.values().stream().anyMatch(contagem -> contagem == 5);
			
		}
	},
	STRAIGHT {
		@Override
		public boolean classificar(Mao mao) {
			int[] cartasOrdenadas = mao.getStreamComValorInteiroDasCartas()
					.sorted()
					.mapToInt(Integer::intValue)
					.toArray();
			if (IntStream.range(0, cartasOrdenadas.length - 1).allMatch(i -> cartasOrdenadas[i + 1] - cartasOrdenadas[i] == 1)) {
				return true;
			}
			
			return cartasOrdenadas[0] == 1 && IntStream.range(1, cartasOrdenadas.length - 1).allMatch(i -> cartasOrdenadas[i + 1] - cartasOrdenadas[i] == 1);
		}
	},
	TRINCA {
		@Override
		public boolean classificar(Mao mao) {
			Map<Integer, Long> contagemPorValor = mao.getStreamComValorInteiroDasCartas()
					.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
			
			return contagemPorValor.values().stream().anyMatch(contagem -> contagem == 3);
			
		}
	},
	DOIS_PARES {
		@Override
		public boolean classificar(Mao mao) {
			Map<Integer, Long> contagemPorValor = mao
					.getStreamComValorInteiroDasCartas()
					.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
			
			int cont = 0;
			for (Entry<Integer, Long> entry : contagemPorValor.entrySet()) {
				if (entry.getValue() == 2) {
					cont++;
					if (cont == 2) {
						return true;
					}
				}	
			}
			
			return false;
			
		}
	},
	PAR {
		@Override
		public boolean classificar(Mao mao) {
			Map<Integer, Long> contagemPorValor = mao
					.getStreamComValorInteiroDasCartas()
					.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
			
			return contagemPorValor.values().stream().anyMatch(contagem -> contagem == 2);
			
		}
	},
	
	CARTA_ALTA {
		@Override
		public boolean classificar(Mao mao) {
			return true;
		}
	};	
	
	public abstract boolean classificar(Mao mao);
}
