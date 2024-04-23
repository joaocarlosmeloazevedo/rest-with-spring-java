package br.com.neutron.calculator;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum (@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo) { //TO-DO String por enquanto para tratar exceções
			
		return 1D;
	}
}
