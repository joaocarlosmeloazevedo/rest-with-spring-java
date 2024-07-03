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
public class PersonController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum (@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
	
	if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Please set a numeric value!");
	}
	return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	
	}
	
}