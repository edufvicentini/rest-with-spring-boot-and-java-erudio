package br.com.frota;

public enum CalculationTypeEnum {
	ctSum("sum"), 
	ctSubtract("subtract"), 
	ctMultiply("multiply"), 
	ctdisivion("division"), 
	ctMean("mean"), 
	ctSquareroot("squareroot"),
	ctNone("");
	
	public String valor;
	
	CalculationTypeEnum(String value) {
		valor = value;
	}
	
	public String getValor(){
		  return valor;
	}
	
	public static CalculationTypeEnum pathOperatorToEnum(String s) {
		switch(s) {
			case "sum": return ctSum;
			case "subtract": return ctSubtract;
			case "multiply": return ctMultiply;
			case "division": return ctdisivion;
			case "mean": return ctMean;
			case "squareroot": return ctSquareroot;
		};
		return ctNone;
	}
}
