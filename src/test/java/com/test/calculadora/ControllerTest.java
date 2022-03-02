package com.test.calculadora;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.test.calculadora.controller.Controller;
import com.test.calculadora.service.CalculatorService;




@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
class ControllerTest {

	private Controller createTestSubject() {
		return new Controller();
	}

	
	@MockBean
	CalculatorService calculator;
	
	
	@Autowired
	Controller controller;
	
	@Autowired
	  MockMvc mockMvc;
	
   
	static String number1;
	static String number2;
	static Character operator;

	@BeforeEach
	void initAll() {
		number1 = "400";
		number2 = "200";
		operator = '+';
	}
	

    @Test
    void properData() throws Exception {
    	
    	Mockito.when(calculator.executeOperation(number1, number2, operator)).thenReturn(new BigDecimal("12"));
    	
    	 mockMvc.perform(post("/operations/operation")
    			 .contentType(MediaType.APPLICATION_JSON)
    			 .content(
    	 		 "{\"operand1\":\"400\","
    	 		+ "\"operand2\":\"200\","
    	 		+ "\"operator\":\"-\"}"))
         .andExpect(status().is(200));
        
                
    }
    
    @Test
    void missingNumber() throws Exception {
    	
    	Mockito.when(calculator.executeOperation(number1, number2, operator)).thenReturn(new BigDecimal("12"));
    	
    	 mockMvc.perform(post("/operations/operation")
    			 .contentType(MediaType.APPLICATION_JSON)
    			 .content(
    	 		 "{"
    	 		+ "\"operand2\":\"200\","
    	 		+ "\"operator\":\"-\"}"))
         .andExpect(status().is(406));
        
                
    }
    
    @Test
    void missingOperator() throws Exception {
    	
    	Mockito.when(calculator.executeOperation(number1, number2, operator)).thenReturn(new BigDecimal("12"));
    	
    	 mockMvc.perform(post("/operations/operation")
    			 .contentType(MediaType.APPLICATION_JSON)
    			 .content(
    			 "{\"operand1\":\"400\","
    			+ "\"operand2\":\"200\"}"))
         .andExpect(status().is(406));
        
                
    }

}
