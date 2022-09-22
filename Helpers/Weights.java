package Helpers;

//весовые приоритеты символов
public class Weights {
    public static int getChWeight(Character ch) {
            if (ch == '/' || ch == '*') return 4;
            else if (ch == '+' || ch == '-') return 3;
            else if (ch == '(') return 2;
            else if (ch == ')') return 1;
            else return 0;
    }
}
