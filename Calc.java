import Helpers.UserInput;
import Helpers.ToRpn;
import Helpers.RpnCalc;

public class Calc {

    private static final String promptMsg = "Ввведите выражение, например 2+2*2:";

    public static void main(String[] args) {

        UserInput ui = new UserInput(promptMsg);
        ToRpn Rpn = new ToRpn(ui.getInput());
        String rpn = Rpn.getRpn();
        RpnCalc calc = new RpnCalc(rpn);
        System.out.println(calc.getCalcResult());

    }

}