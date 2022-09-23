package Helpers;

import java.util.InputMismatchException;
import java.util.Stack;
import Helpers.Weights;

public class ToRpn {

    private String rpn = new String();

    public ToRpn(String expression) {
        if (checkParenthesis(expression)) {
            convertToRpn(expression.replaceAll("\\s",""));
        } else {
            throw new InputMismatchException("Input is wrong");
        }
     }

    public String getRpn() {
        return this.rpn;
    }

    //проверка на скобки
    private boolean checkParenthesis(String input) {
        Stack<Character> open = new Stack<>();
        Stack<Character> close = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            switch (input.charAt(i)) {
                case ('('):
                    open.push(input.charAt(i));
                    break;
                case (')'):
                    close.push(input.charAt(i));
                    break;
            }
        }
        if (open.size() == close.size()) {
            return true;
        } else {
            return false;
        }
    }
    private void convertToRpn(String expr) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i=0; i<expr.length(); i++) {
            priority = Weights.getChWeight(expr.charAt(i));
            //если читаем цифру, то просто докинем ее в вывод
            if (priority == 0) {
                result +=  expr.charAt(i) ;
            }
            //открывающая скобка
            if (priority == 2) {
                stack.push(expr.charAt(i));
            }
            // если встречаем знаки операций +-*/
            if (priority > 2) {
                result += " "; //добавляем пробел, чтобы разделить числа в выводе
                //пока стек не пустой
                while (!stack.empty()) {
                    if (Weights.getChWeight(stack.peek()) >= priority){ //берем из стэка верхний элемент и проверяем его приоритет
                        result += stack.pop() + " "; //если приоритет больше или равен текущему, то забираем его в вывод
                    } else {
                        break;
                    }
                }
                stack.push(expr.charAt(i)); // текущий символ пишем в стэк
            }
            //закрывающая скобка
            if (priority == 1) {
                while (Weights.getChWeight(stack.peek()) != 2) { //пока не доберемся до открывающей скобки
                    result += " " + stack.pop(); //все знаки пишем в вывод
                }
                stack.pop(); //удаляем открывающую скобку
            }
        }
        //если в стэке что-то еще остается
        while (!stack.empty()) {
            result += " " + stack.pop();
        }

        this.rpn = result;
    }

}
