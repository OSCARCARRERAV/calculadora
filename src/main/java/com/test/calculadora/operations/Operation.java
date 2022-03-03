package com.test.calculadora.operations;

import java.math.BigDecimal;

public interface Operation {
	
	BigDecimal exec(BigDecimal operand1,BigDecimal operand2);
	
	boolean valid(char operator);
}
