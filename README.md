# Poker Test JUnit 5

This small project is an example of **@ParameterizedTest** usage for JUnit 5 test methods. It was also used **chain of responsability** behavior design pattern for the poker hands validation on the business logic.
```
package com.m2g2.handler;

import com.m2g2.enums.Classificacao;
import com.m2g2.model.Mao;

public abstract class AbstractHandler {

	protected Classificacao classificacao;
	protected AbstractHandler proximo;
	
	public abstract Classificacao classificar(Mao mao);

}
```
## Dependency versions

- Java 17
- JUnit 5.10.0

