package com.m2g2.model;

import com.m2g2.enums.Classificacao;
import com.m2g2.enums.ClassificacaoHelper;

public class FlushHandler extends AbstractHandler {

	public FlushHandler() {
		classificacao = Classificacao.FLUSH;
		proximo = new StraightHandler();
	}
	
	@Override
	public Classificacao classificar(Mao mao) {
		if (ClassificacaoHelper.isFlush(mao)) {
			return classificacao;
		}
		return proximo.classificar(mao);
	}

}
