package Skills.JunitWitMockito.calculator;

public class calculator {

	
	public int add(int a ,int b ) {
		return a + b;
	}
	public boolean isEven(int a){
		return a % 2 == 0;
		
	}
	public int percent(int a) {
		a = a %	100;
		return a;
		
	}
}
