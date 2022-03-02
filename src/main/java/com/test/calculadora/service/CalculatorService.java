package com.test.calculadora.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.calculadora.exception.NotAcceptableException;
import com.test.calculadora.operations.SubstractOperation;
import com.test.calculadora.operations.SumOperation;
import com.test.calculadora.utils.Constants;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

@Service
public class CalculatorService {

	SumOperation sum;
	SubstractOperation substract;
	
	
	TracerImpl tracer=new TracerImpl();
	

	public CalculatorService(SumOperation sum, SubstractOperation substract) {
		super();
		this.sum = sum;
		this.substract = substract;
	
	}

	public BigDecimal executeOperation(String operand1, String operand2, Character operator)
			throws NotAcceptableException, NumberFormatException {

		BigDecimal number1;
		BigDecimal number2;
		BigDecimal result;

		try {

			number1 = new BigDecimal(operand1);
			number2 = new BigDecimal(operand2);

		} catch (NumberFormatException n) {
			tracer.trace(Constants.WRONG_NUMBER);
			throw new NotAcceptableException(Constants.WRONG_NUMBER);
		}

		switch (operator) {
		case '+':
			result= sum.exec(number1, number2);
		 tracer.trace(resultTrace(operand1,operand2,operator,result));
		 return result;
		case '-':
			result= substract.exec(number1, number2);
		 tracer.trace(resultTrace(operand1,operand2,operator,result));
		 return result;
		default:
			throw new NotAcceptableException(Constants.WRONG_OPERATOR + operator.toString());
		}

	}

	private String resultTrace(String operand1, String operand2, Character operator, BigDecimal result) {

		return Constants.OPERATION.concat(operand1)
				.concat(operator.toString().concat(operand2).concat("=").concat(result.toString()));

	}
}
