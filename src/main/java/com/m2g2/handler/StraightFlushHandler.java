package com.m2g2.handler;

import com.m2g2.enums.Classificacao;
import com.m2g2.enums.ClassificacaoHelper;
import com.m2g2.model.Mao;

public class StraightFlushHandler extends AbstractHandler {
	
	public StraightFlushHandler() {
		this.classificacao = Classificacao.STRAIGHT_FLUSH;
		this.proximo = new QuadraHandler();
	}
	

	@Override
	public Classificacao classificar(Mao mao) {
		if (ClassificacaoHelper.isStraight(mao) && ClassificacaoHelper.isFlush(mao)) {
			return classificacao;
		}
		return proximo.classificar(mao);
	}

}
