package com.m2g2.model;

import com.m2g2.enums.Classificacao;

public abstract class AbstractHandler {

	protected Classificacao classificacao;
	protected AbstractHandler proximo;
	
	public abstract Classificacao classificar(Mao mao);

}
