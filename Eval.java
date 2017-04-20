import java.util.*;

public class Eval{

	public static void main(String[] args){
		System.out.println(eval("0 1 2 3 + * + 10 - -9 * 6 % 6 * 9 /"));
	}

	public static double eval(String input){
		String[] elements = input.split(" ");
		ArrayDeque<Double> s = new ArrayDeque<Double>();
		for (int i = 0; i < elements.length; i ++){
			if (isOperand(elements[i])){
				s.addFirst(new Double(apply(elements[i], s.removeFirst(), s.removeFirst())));
			}
			else {
				s.addFirst(new Double(elements[i]));
			}
		}
		return s.removeFirst();
	}

	private static boolean isOperand(String input){
		return input.equals("+") || input.equals("-") || input.equals("/") || input.equals("%") || input.equals("*");
	}

	private static double apply(String operand, double a, double b){
		if (operand.equals("+")) return a + b;
		else if (operand.equals("-")) return b - a;
		else if (operand.equals("/")) return b / a;
		else if (operand.equals("*")) return a * b;
		else return b % a;
	}

}