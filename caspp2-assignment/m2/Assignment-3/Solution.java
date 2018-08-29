import java.util.Scanner;
/**.
    *@author: Gangadhar
    *Date:28/08/18
    *power function.
*/
public final class Solution {
    /*
    Do not modify this main function.
    */
    private Solution() {
    /**
    *empty constructor
    */
    }
    /**.
    *@param args is argument
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    *Need to write the power function and print the output.
    */
    /**
    *@param base base
    *@param exp exponential
    *@return long
    */
    public static long power(final int base, final int exp) {
        if (exp != 0) {
            return (base * power(base, (exp - 1)));
        } else {
            return 1;
        }
    }
}
