package com.m2g2.handler;

import com.m2g2.enums.Classificacao;
import com.m2g2.model.Mao;

public abstract class AbstractHandler {

	protected Classificacao classificacao;
	protected AbstractHandler proximo;
	
	public abstract Classificacao classificar(Mao mao);

}
