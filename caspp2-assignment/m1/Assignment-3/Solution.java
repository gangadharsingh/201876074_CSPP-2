import java.util.Scanner;
/**
*   @author : Gangadhar.
*   Date: 28/08/18.
*   fahrenheit to degere.
*/
public final class Solution {
    /**.
    * {Do not modify this main function}
    */
    public static final double NUM1 = 32;
    /**
    *Do not modify this main function.
    */
    public static final double NUM2 = 0.5556;
    /**
    *Do not modify this main function.
    */
    private Solution() {
        /**
        *empty constructor.
        */
    }
    /**.
    * @param  args standard main parameters.
    */
    public static void main(final String[] args) {
    /**
         *main function
    */
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        System.out.println(calculateFromDegreesToFarenheit(degreesCelsius));
    }
    /*
    Need to fill the calculateFromDegreesToFarenheit
    function and print the output
    of fahrenheit.
    */
    /**
      *@param f arguments
      *@return int
     *
    */
    public static double calculateFromDegreesToFarenheit(final double f) {
        return (f - NUM1) * (NUM2);
    }
}
