package br.com.neutron.calculator;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.neutron.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum (@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
	
	if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return convertToDouble(numberOne) + convertToDouble(numberTwo);
	
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction (@PathVariable(value = "numberOne") String numberOne,
							   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		
	if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	Double result = convertToDouble(numberOne) - convertToDouble(numberTwo);
	
	return convertToPositive(result);
		
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication (@PathVariable(value = "numberOne") String numberOne,
							   	  @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		
	if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	Double result = convertToDouble(numberOne) * convertToDouble(numberTwo);
	
	return convertToPositive(result);
		
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division (@PathVariable(value = "numberOne") String numberOne,
							   	  @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		
	if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	Double result = convertToDouble(numberOne) / convertToDouble(numberTwo);
	
	return convertToPositive(result);
		
	}
	
	@RequestMapping(value = "/medium/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double medium (@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
	
	if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot (@PathVariable(value = "numberOne") String numberOne)
	throws Exception{
	
	if(!isNumeric(numberOne)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return Math.sqrt(convertToDouble(numberOne));
	
	}
	
	
	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D; //Double zerado
		
		String number = strNumber.replaceAll(",", ".");
		
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
	
	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	private Double convertToPositive(Double result) {
			if (result > 0) return result;
			
			return result * -1;
}
	
}
