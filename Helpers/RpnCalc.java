package Helpers;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Stack;
import Helpers.Weights;

public class RpnCalc {

    private double calcResult = 0.0;

    public RpnCalc(String rpn) {
        this.calcResult = Calc(rpn);
    }

    public double getCalcResult() {
        return this.calcResult;
    }

    private double Calc(String rpn) {
        String value = new String();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            }
            //если это не оператор
            if (Weights.getChWeight(rpn.charAt(i)) == 0) {
                //перебираем строчку до пробела, чтобы получить число из строки целиком
                while (rpn.charAt(i) != ' ' && Weights.getChWeight(rpn.charAt(i)) == 0) {
                    value += rpn.charAt(i++);
                    if (i == rpn.length()) {
                        break;
                    }
                }
                //помещаем число в стек
                try{
                    stack.push(Double.parseDouble(value));
                } catch (NumberFormatException ex) {
                    throw new InputMismatchException("Input is wrong");
                }
                //очищаем строку
                value = new String();
            }
            //если появился знак операции
            if (Weights.getChWeight(rpn.charAt(i)) > 2) {
                //забираем из стэка два числа
                try {
                    Double first = stack.pop(), second = stack.pop();
                    //производим операцию с ними
                    switch (rpn.charAt(i)) {
                        case ('+'):
                            stack.push(first + second);
                            break;
                        case ('-'):
                            stack.push(second - first);
                            break;
                        case ('*'):
                            stack.push(first * second);
                            break;
                        case ('/'):
                            stack.push(second / first);
                            break;
                    }
                } catch (EmptyStackException ex) {
                    System.out.println("Rpn string is wrong");
                }
            }
        }
        try {
            return stack.pop();
        } catch (EmptyStackException ex) {
            return 0.0F;
        }
    }

}
