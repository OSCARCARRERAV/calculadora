package com.test.calculadora.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.test.calculadora.exception.NotAcceptableException;
import com.test.calculadora.utils.Constants;

@Service
public class CalculatorService {

	@Value("#{'${operators.valid}'.split(',')}")
	List<Character> operatorsList;

	public BigDecimal executeOperation(String operand1, String operand2, Character operator)
			throws NotAcceptableException, NumberFormatException {

		checkOperator(operator);

		try {

			BigDecimal number1 = new BigDecimal(operand1);
			BigDecimal number2 = new BigDecimal(operand2);
			BigDecimal result;
			switch (operator) {
			case '+':
				result=number1.add(number2);
				
				return result;
			case '-':
				result=number1.subtract(number2);
				
				return result;
			default:
			}

		} catch (NumberFormatException n) {
			
			throw new NotAcceptableException(Constants.WRONG_NUMBER);
		}

		return null;

	}

	private void checkOperator(Character operator) throws NotAcceptableException {

		if (!operatorsList.contains(operator)) {
			
			throw new NotAcceptableException(Constants.WRONG_OPERATOR + operatorsList.toString());
		}
	}

	private String resultTrace(String operand1, String operand2, Character operator,BigDecimal result) {
		
		return Constants.OPERATION.concat(operand1).concat(operator.toString().concat(operand2).concat("=").concat(result.toString()));
		
	}
}
