package Helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private String input;
    private float firstArg = 0.0F;
    private float secondArg = 0.0F;
    private String operator = "";
    private final String rgTemplate = "^([0-9.]*)([\\+\\-\\*\\/])([0-9.]*)$";

    public InputParser(String input) {
        this.input = input;
        this.setArgs();
    }

    private boolean testInput() {
        Pattern pattern = Pattern.compile(this.rgTemplate);
        Matcher matcher = pattern.matcher(this.input);
        return matcher.matches();
    }

    private void setArgs () {
        Pattern pattern = Pattern.compile(this.rgTemplate);
        Matcher matcher = pattern.matcher(this.input);
        if (testInput() && matcher.groupCount() == 3) {
            while(matcher.find()) {
                this.firstArg = Float.valueOf(matcher.group(1));
                this.secondArg =Float.valueOf(matcher.group(3));
                this.operator = String.valueOf(matcher.group(2));
            }
        }
    }

    public float getFirstArg() {
        return firstArg;
    }

    public float getSecondArg() {
        return secondArg;
    }

    public String getOperator() {
        return operator;
    }
}


