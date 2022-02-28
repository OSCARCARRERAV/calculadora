package com.test.calculadora;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.calculadora.exception.NotAcceptableException;
import com.test.calculadora.service.CalculatorService;

@SpringBootTest
class CalculatorServiceTests {
	
	@Autowired
	CalculatorService calculatorService;

	static String number1;
	static String number2;
	static String wrongNumber1;
	static String wrongNumber2;
	static Character addOperator;
	static Character substractOperator;
	@Value("#{'${operators.valid}'.split(',')}")
	List<Character> operatorsList;

	@BeforeEach
	void initAll() {
		number1 = "150";
		number2 = "50.7658";
		wrongNumber1 = "zfg32";
		wrongNumber2 = "198,54";
		addOperator = '+';
		substractOperator = '-';
	}

	@Test
	void firstNumberWrong() {

		assertThrows(NotAcceptableException.class, () -> {
			calculatorService.executeOperation(wrongNumber2, wrongNumber2, addOperator);
		});

	}
	
	

	@Test
	void secondNumberWrong() {

		assertThrows(NotAcceptableException.class, () -> {
			
			calculatorService.executeOperation(number1, wrongNumber1, addOperator);
		});

	}

	@Test
	void wrongOperator()  {
		assertThrows(NotAcceptableException.class, () -> {
		Character operator = ')';
		calculatorService.executeOperation(number1, number2, operator);
		});
	}
	
	@Test
	void sumOK() throws  NotAcceptableException {
		
		BigDecimal result=calculatorService.executeOperation(number1, number2, addOperator);
		BigDecimal expectedResult=new BigDecimal("200.7658");
		assertEquals(result,expectedResult);
		assertEquals(7,result.precision());
		assertEquals(1,result.signum());
	}
	
	@Test
	void substractOK() throws  NotAcceptableException {
		
		BigDecimal result=calculatorService.executeOperation(number1, number2, substractOperator);
		BigDecimal expectedResult=new BigDecimal("99.2342");
		assertEquals(result,expectedResult);
		assertEquals(6,result.precision());
		assertEquals(1,result.signum());
		
	}
	
	@Test
	void substractionSecondOperandMinor() throws NumberFormatException, NotAcceptableException {
		BigDecimal result=calculatorService.executeOperation(number2, number1, substractOperator);
		assertEquals(-1,result.signum());
	}
	
}