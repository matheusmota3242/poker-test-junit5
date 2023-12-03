package com.m2g2.model;

import com.m2g2.enums.Classificacao;
import com.m2g2.enums.ClassificacaoHelper;
import com.m2g2.enums.ValorCarta;

public class RoyalStraightFlushHandler extends AbstractHandler {

	public RoyalStraightFlushHandler() {
		this.classificacao = Classificacao.ROYAL_STRAIGHT_FLUSH;
		this.proximo = new StraightFlushHandler();
	}
	
	@Override
	public Classificacao classificar(Mao mao) {
		int[] cartasOrdenadas = mao.getStreamComValorInteiroDasCartas()
				.sorted()
				.mapToInt(Integer::intValue)
				.toArray();
		if (cartasOrdenadas[4] == ValorCarta.K.getValor() 
				&& cartasOrdenadas[0] == ValorCarta.A.getValor() && ClassificacaoHelper.isStraight(mao) && ClassificacaoHelper.isFlush(mao)) {
				return classificacao;
		}
		
		return proximo.classificar(mao);
	}


}
