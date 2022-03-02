package com.test.calculadora.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SubstractOperation {
	
	
	public BigDecimal exec(BigDecimal operand1,BigDecimal operand2) {
		return operand1.subtract(operand2);
	}

}
