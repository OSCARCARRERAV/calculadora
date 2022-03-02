package com.test.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.test.calculadora.exception.NotAcceptableException;
import com.test.calculadora.operations.SubstractOperation;
import com.test.calculadora.operations.SumOperation;
import com.test.calculadora.utils.Constants;

@Service
public class CalculatorService {

	SumOperation sum;
	SubstractOperation substract;

//	@Autowired
//	TracerAPI tracer;

	// TracerImpl tracer = new TracerImpl();

	public CalculatorService(SumOperation sum, SubstractOperation substract) {
		super();
		this.sum = sum;
		this.substract = substract;
	}

	public BigDecimal executeOperation(String operand1, String operand2, Character operator)
			throws NotAcceptableException, NumberFormatException {

		BigDecimal number1;
		BigDecimal number2;

		try {

			number1 = new BigDecimal(operand1);
			number2 = new BigDecimal(operand2);

		} catch (NumberFormatException n) {
			// tracer.trace(Constants.WRONG_NUMBER + operatorsList.toString());
			throw new NotAcceptableException(Constants.WRONG_NUMBER);
		}

		switch (operator) {
		case '+':
			return sum.exec(number1, number2);
		// tracer.trace(resultTrace(operand1,operand2,operator,result));
		case '-':
			return substract.exec(number1, number2);
		// tracer.trace(resultTrace(operand1,operand2,operator,result));
		default:
			throw new NotAcceptableException(Constants.WRONG_OPERATOR + operator.toString());
		}

	}

	private String resultTrace(String operand1, String operand2, Character operator, BigDecimal result) {

		return Constants.OPERATION.concat(operand1)
				.concat(operator.toString().concat(operand2).concat("=").concat(result.toString()));

	}
}
