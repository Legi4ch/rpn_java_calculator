import Helpers.InputParser;
import Helpers.UserInput;

public class Calc {

    private static final String promptMsg = "Ввведите выражение, например 2+3:";
    private static final String divErMsg = "Деление на 0!";

    public static void main(String[] args) {
        UserInput ui = new UserInput(promptMsg);
        InputParser ip = new Helpers.InputParser(ui.getInput());
        switch (ip.getOperator()) {
            case ("+"):
                System.out.println(ip.getFirstArg() + ip.getSecondArg());
                break;
            case ("-"):
                System.out.println(ip.getFirstArg() - ip.getSecondArg());
                break;
            case ("*"):
                System.out.println(ip.getFirstArg() * ip.getSecondArg());
                break;
            case ("/"):
                if (ip.getSecondArg() != 0.0F) {
                    System.out.println(ip.getFirstArg() / ip.getSecondArg());
                } else {
                    System.out.println(divErMsg);
                }
                break;
        }
    }
}