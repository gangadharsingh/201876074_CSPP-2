import java.util.Scanner;
/**
 *@author gangadharsingh.
 * Class for input validator.
 */
class InputValidator {
    /**
     *Write the atrributes and methods for InputValidator.
     */
    public static final int NUM = 6;
    /**
     * defining empty constructor.
     */
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
        if (str.length() >= NUM) {
            return true;
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * empty constructor.
         */
    }
    /**
     * main class.
     * @param args arguement of main function.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }

}
