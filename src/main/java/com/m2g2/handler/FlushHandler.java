package com.m2g2.handler;

import com.m2g2.enums.Classificacao;
import com.m2g2.enums.ClassificacaoHelper;
import com.m2g2.model.Mao;

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
