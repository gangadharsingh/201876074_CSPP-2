import java.util.Scanner;
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    private String str;
    /**
     * Constructs the object.
     *
     * @param      stringinput  The stringinput
     */
    InputValidator(final String stringinput) {
        this.str = stringinput;
    }
    /**
     * method about validation of data.
     *
     * @return     {boolean value}.
     */
    public boolean validateData() {
        if (str.length() >= 6) {
            return true;
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * main class.
     */
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }

}
