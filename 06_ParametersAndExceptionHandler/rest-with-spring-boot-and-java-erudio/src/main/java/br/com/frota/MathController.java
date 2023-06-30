package br.com.frota;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@RequestMapping(value = "/{operator}/{pathNumbers}", method = RequestMethod.GET)
	public Double calculate(
			@PathVariable(value = "operator") String operator,
			@PathVariable(value = "pathNumbers") String pathNumbers
		) throws Exception {		
		Calculator calc = new Calculator();
		
		CalculationTypeEnum calcType = CalculationTypeEnum.pathOperatorToEnum(operator);
		if (calcType == null) throw new Exception("cannot handle operator");

		ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(pathNumbers.split("'")));
		
		calc.calculationType = calcType;
		calc.numbers = numbers;
		calc.calculate();
		
		return calc.Result();
	
	}
}
