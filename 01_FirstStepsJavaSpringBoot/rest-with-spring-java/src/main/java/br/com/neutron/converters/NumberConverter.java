package br.com.neutron.converters;

public class NumberConverter {
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D; //Double zerado
		
		String number = strNumber.replaceAll(",", ".");
		
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
	
	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static Double convertToPositive(Double result) {
			if (result > 0) return result;
			
			return result * -1;
	}
}
