/**.
    *Date: 28/08/18.
    *Name: Gangadhar.
    *Remainder calculation
*/
import java.util.*;
public final class Degreestofahrenheit {
    /**
    *calculating quotient and remainder.
    */
    public static final int NUM1 = 30;
    /**
    *calculating quotient and remainder.
    */
    private Degreestofahrenheit() {
        /**empty constructor.
        */
    }
    /**.
    * @param  args standard main parameters
    */
    public static void main(final String[] args) {
        // int a = NUM1;
        Scanner input = new Scanner(System.in);
        Double a = input.nextDouble();
        System.out.println("Fahrenheit is: " + (1.8*a + 32)+ " degree");
    }
}
