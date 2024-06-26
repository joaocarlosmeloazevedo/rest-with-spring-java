package br.com.neutron.controllers;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.neutron.converters.NumberConverter;
import br.com.neutron.exceptions.UnsupportedMathOperationException;
import br.com.neutron.math.SimpleMath;

@RestController
public class MathController {
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum (@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
	
	if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction (@PathVariable(value = "numberOne") String numberOne,
							   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		
	if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	//This line of code does not let the user use negative numbers.
	Double result = math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	
	return NumberConverter.convertToPositive(result);
		
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication (@PathVariable(value = "numberOne") String numberOne,
							   	  @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		
	if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	Double result = math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	
	return NumberConverter.convertToPositive(result);
		
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division (@PathVariable(value = "numberOne") String numberOne,
							   	  @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		
	if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	Double result = math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	
	return NumberConverter.convertToPositive(result);
		
	}
	
	@RequestMapping(value = "/medium/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double medium (@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
	
	if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo) / 2);
	
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot (@PathVariable(value = "numberOne") String numberOne)
	throws Exception{
	
	if(!NumberConverter.isNumeric(numberOne)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return math.squareRoot(NumberConverter.convertToDouble(numberOne));
	
	}
	
}
