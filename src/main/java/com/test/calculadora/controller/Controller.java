package com.test.calculadora.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.calculadora.DTO.RequestDTO;
import com.test.calculadora.exception.NotAcceptableException;
import com.test.calculadora.service.CalculatorService;
import com.test.calculadora.utils.Constants;

@RestController
@CrossOrigin
@RequestMapping("/operations")
public class Controller {

	@Autowired
	CalculatorService calcService;

	@PostMapping("/operation")
	public @ResponseBody BigDecimal executeOperation(@RequestBody RequestDTO request) throws NotAcceptableException {

		String number1 = request.getOperand1();
		String number2 = request.getOperand2();
		Character operator = request.getOperator();

		if (number1 != null && number2 != null && operator != null) {
			return calcService.executeOperation(number1, number2, operator);
		}

		if (number1 == null || number2 == null) {
			throw new NotAcceptableException(Constants.MISSING_NUMBER);
		}

		else {
			throw new NotAcceptableException(Constants.MISSING_OPERATOR);
		}

	}
}