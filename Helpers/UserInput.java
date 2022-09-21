package Helpers;
import java.util.Scanner;

public class UserInput {
    private String input = "";

    public UserInput(String s) {
      this.input = setInput(s);
    }

    private String setInput(String promptMsg) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        System.out.println(promptMsg);
        result = scanner.next();
        return result;
    }

    public String getInput() {
        return this.input;
    }
}
