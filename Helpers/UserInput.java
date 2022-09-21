package Helpers;
import java.util.Scanner;

public class UserInput {
    private String input = "";

    public UserInput(String s) {
      this.input = setInput(s);
    }

    private String setInput(String promptMsg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(promptMsg);
        return scanner.next();
    }

    public String getInput() {
        return this.input;
    }
}
