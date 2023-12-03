package com.m2g2.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.m2g2.enums.Classificacao;
import com.m2g2.enums.NaipeCarta;
import com.m2g2.enums.ValorCarta;
import com.m2g2.model.builder.CartaBuilder;
import com.m2g2.model.builder.MaoBuilder;

class MaoTest {

	@ParameterizedTest
	@CsvSource(value = {
			"COPAS,N10,  COPAS, J,  COPAS, Q,  COPAS,K,  COPAS,A,  ROYAL_STRAIGHT_FLUSH",
			"PAUS,N9,  PAUS,N10,  PAUS,J,  PAUS, Q,  PAUS,K,  STRAIGHT_FLUSH",
			"PAUS,N10,  COPAS,A,  PAUS, A,  OURO,A,  ESPADA,A,  QUADRA",
			"PAUS,K,  COPAS,A,  PAUS, A,  OURO,A,  ESPADA,K,  FULL_HOUSE",
			"OURO,N2,  OURO,N5,  OURO,A,  OURO,N9,  OURO,Q,  FLUSH",
			"PAUS,A,  COPAS,N2,  PAUS, N3,  OURO,N4,  ESPADA,N5,  STRAIGHT",
			"PAUS,K,  COPAS,A,  PAUS, A,  OURO,A,  ESPADA,J,  TRINCA",
			"PAUS,N2,  COPAS,N2,  PAUS, N4,  OURO,N4,  ESPADA,N8,  DOIS_PARES",
			"PAUS,K,  COPAS,K,  PAUS, N8,  OURO,A,  ESPADA,J,  PAR",
			"PAUS,N3,  COPAS,K,  PAUS, N8,  OURO,A,  ESPADA,J,  CARTA_ALTA",
	})
	void teste(NaipeCarta naipe1, ValorCarta valor1
			,NaipeCarta naipe2, ValorCarta valor2,
			NaipeCarta naipe3, ValorCarta valor3,
			NaipeCarta naipe4, ValorCarta valor4,
			NaipeCarta naipe5, ValorCarta valor5, Classificacao classificacaoEsperada) {
		// Arrange
		Carta carta1 = CartaBuilder.umaCarta()
				.comNaipe(naipe1)
				.comValor(valor1)
				.build();
		
		Carta carta2 = CartaBuilder.umaCarta()
				.comNaipe(naipe2)
				.comValor(valor2)
				.build();
		Carta carta3 = CartaBuilder.umaCarta()
				.comNaipe(naipe3)
				.comValor(valor3)
				.build();
		Carta carta4 = CartaBuilder.umaCarta()
				.comNaipe(naipe4)
				.comValor(valor4)
				.build();
		Carta carta5 = CartaBuilder.umaCarta()
				.comNaipe(naipe5)
				.comValor(valor5)
				.build();
		Mao mao = MaoBuilder.umaMao().comCartas(carta1, carta2, carta3, carta4, carta5).build();
		
		// Act
		Classificacao classificacaoObtida = mao.ranking(mao);
		
		// Assert
		Assertions.assertEquals(classificacaoEsperada, classificacaoObtida);
	}
	
	
}
