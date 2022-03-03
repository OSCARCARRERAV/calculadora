package com.test.calculadora.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.calculadora.exception.NotAcceptableException;
import com.test.calculadora.operations.Operation;
import com.test.calculadora.utils.Constants;
import io.corp.calculator.TracerImpl;

@Service
public class CalculatorService {

	@Autowired
	private List<Operation> operations;

	TracerImpl tracer = new TracerImpl();

	public CalculatorService(List<Operation> operations) {
		super();
		this.operations = operations;
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

		for (Operation o : operations) {
			if (o.valid(operator)) {
				result = o.exec(number1, number2);
				tracer.trace(resultTrace(operand1, operand2, operator, result));
				return result;
			}

		}
		tracer.trace(Constants.WRONG_OPERATOR + operator.toString());
		throw new NotAcceptableException(Constants.WRONG_OPERATOR + operator.toString());

	}

	private String resultTrace(String operand1, String operand2, Character operator, BigDecimal result) {

		return Constants.OPERATION.concat(operand1)
				.concat(operator.toString().concat(operand2).concat("=").concat(result.toString()));

	}
}
