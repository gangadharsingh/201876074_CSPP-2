import java.util.Scanner;
/**
*   @author : Gangadhar.
*   Date: 28/08/18.
*   Printing area of a triangle.
*/
public final class Solution {
    /**.
    * {Calculating area of triangle}
    */
    public static final double NUM = 0.5;
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
        int base = scan.nextInt();
        int height = scan.nextInt();
        System.out.println(areaOfTriangle(base, height));
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
    /**
      *@param b arguments
      *@param h arguments
      *@return int
     *
    */
    public static double areaOfTriangle(final double b, final double h) {
        return b * h * NUM;
    }
}





