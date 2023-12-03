package com.m2g2.handler;

import com.m2g2.enums.Classificacao;
import com.m2g2.enums.ClassificacaoHelper;
import com.m2g2.model.Mao;

public class StraightHandler extends AbstractHandler {

	public StraightHandler() {
		classificacao = Classificacao.STRAIGHT;
		proximo = new TrincaHandler();
	}
	
	@Override
	public Classificacao classificar(Mao mao) {
		if (ClassificacaoHelper.isStraight(mao)) {
			return classificacao;
		}
		return proximo.classificar(mao);
	}

	
}
