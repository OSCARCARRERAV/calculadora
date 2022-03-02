package com.test.calculadora.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SumOperation {
	
	public SumOperation() {}
	
	
	public BigDecimal exec(BigDecimal operand1,BigDecimal operand2) {
		return operand1.add(operand2);
	}

}
