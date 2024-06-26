package br.com.neutron.math;


import br.com.neutron.converters.NumberConverter;

public class SimpleMath {
	public Double sum (Double numberOne, Double numberTwo){
		return numberOne + numberTwo;
		}
	
	public Double subtraction (Double numberOne, Double numberTwo){
		Double result = numberOne - numberTwo;
		
		return NumberConverter.convertToPositive(result);
		}
	public Double multiplication (Double numberOne, Double numberTwo){
		Double result = numberOne * numberTwo;
		
		return NumberConverter.convertToPositive(result);
		}
	
	public Double division (Double numberOne,Double numberTwo){
		Double result = numberOne / numberTwo;
		
		return NumberConverter.convertToPositive(result);
		}
	
	public Double medium (Double numberOne, Double numberTwo){
		
		return (numberOne + numberTwo) / 2;
		}
	public Double squareRoot (Double numberOne){
		return Math.sqrt(numberOne);
		}
}
