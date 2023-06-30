package br.com.frota;

import java.util.ArrayList;

import br.com.frota.exceptions.UnsupportedMathOperationException;

public class Calculator {
	public ArrayList<String> numbers;
	public Double[] convertedNumbers;
	public CalculationTypeEnum calculationType;
	private Double result;

	public Double Result() {
		return result;
	}

	public void calculate() throws Exception {
		if (!validateNumericInput(numbers))
			throw new UnsupportedMathOperationException("Please set a numeric value");
		
		ArrayList<Double> convertedNumbers = convertToDouble(numbers);
		switch(calculationType) {
			case ctSum: 	 	result = sum(convertedNumbers); 		break;
			case ctSubtract: 	result = subtract(convertedNumbers);	break;
			case ctMultiply: 	result = multiply(convertedNumbers);	break;
			case ctdisivion: 	result = divide(convertedNumbers);		break;
			case ctMean: 	 	result = mean(convertedNumbers);		break;
			case ctSquareroot: 	result = squareRoot(convertedNumbers);	break;
			case ctNone:		throw new Exception("Invalid operator. You can use only: sum, subtract, multiply, divide, mean and squareroot");
		}
	};
	
	private Double sum(ArrayList<Double> numbers) {
		Double result = numbers.get(0);
		for(int i = 0; i < numbers.size(); i++) {
			if (i == 0) continue;
			
			result += numbers.get(i);
		}
		return result;
	};
	
	private Double subtract(ArrayList<Double> numbers) {
		Double result = numbers.get(0);
		for(int i = 0; i < numbers.size(); i++) {
			if (i == 0) continue;
			
			result -= numbers.get(i);
		};
		return result;
	};
	
	private Double multiply(ArrayList<Double> numbers) {
		Double result = numbers.get(0);
		for(int i = 0; i < numbers.size(); i++) {
			if (i == 0) continue;
			
			result *= numbers.get(i);
		};
		return result;
	}
	
	private Double divide(ArrayList<Double> numbers) {
		Double result = numbers.get(0);
		for(int i = 0; i < numbers.size(); i++) {
			if (i == 0) continue;
			
			if(numbers.get(i) == 0) {
				throw new UnsupportedMathOperationException("Cannot divide by zero");
			};
			
			result /= numbers.get(i);
		};
		return result;
	}
	
	private Double mean(ArrayList<Double> numbers) {
		return sum(numbers) / numbers.size();
	}
	
	private Double squareRoot(ArrayList<Double> numbers) {	
		if (numbers.size() > 1) throw new UnsupportedMathOperationException("You can only operate squareroot for one number");
		return Math.sqrt(numbers.get(0));
	}
	
	private ArrayList<Double> convertToDouble(ArrayList<String> strNumbers) {
		ArrayList<Double> result;
		
		result = new ArrayList<Double>();
		
		strNumbers.forEach(number -> {
			String formattedNumber = number.replaceAll(",", ".");
			result.add(Double.parseDouble(formattedNumber));
		});
		return result;
	}

	private boolean validateNumericInput(ArrayList<String> strNumbers) {
		if (strNumbers == null) return false;

		for (String number : strNumbers) {
			if (!number.replaceAll(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+")) {
				return false;
			}
		};
		return true;
	};
}
