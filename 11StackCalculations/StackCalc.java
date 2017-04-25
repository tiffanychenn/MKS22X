import java.util.*;

public class StackCalc{

    public static void main(String[] args){
        System.out.println(eval("10 2 +"));//12.0
        System.out.println(eval("10 2 -"));//8.0
        System.out.println(eval("10 2.0 +"));//12.0
        System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
        System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
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