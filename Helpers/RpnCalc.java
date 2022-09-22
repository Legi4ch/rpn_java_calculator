package Helpers;

import java.util.EmptyStackException;
import java.util.Stack;
import Helpers.Weights;

public class RpnCalc {

    private float calcResult = 0.0F;

    public RpnCalc(String rpn) {
        this.calcResult = Calc(rpn);
    }

    public float getCalcResult() {
        return this.calcResult;
    }

    private float Calc(String rpn) {
        String value = new String();
        Stack<Float> stack = new Stack<>();
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
                stack.push(Float.parseFloat(value));
                //очищаем строку
                value = new String();
            }
            //если появился знак операции
            if (Weights.getChWeight(rpn.charAt(i)) > 2) {
                //забираем из стэка два числа
                try {
                    float first = stack.pop(), second = stack.pop();
                    //производим операцию с ними
                    switch (rpn.charAt(i)) {
                        case ('+'):
                            stack.push(first + second);
                            break;
                        case ('-'):
                            stack.push(first - second);
                            break;
                        case ('*'):
                            stack.push(first * second);
                            break;
                        case ('/'):
                            stack.push(first / second);
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
