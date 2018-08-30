import java.util.Scanner;
/**.
    *@author: Gangadhar
    *Date:28/08/18
    *gcd.
*/
public final class Solution {
    /**.
    *Do not modify this main function.
    */
    private Solution() {
    /**
    *empty constructor
    */
    }
    /**.
    *@param args is argument
    */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /*
    Need to write the gcd function and print the output.
    */
    /**
    *@param a variable
    *@param b variable
    *@return int
    */
    public static int gcd(final int a, final int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == b) {
            return b;
        }
        if (a > b) {
            return gcd((a - b), b);
        } else {
            return gcd(a, (b - a));
        }
    }
}
