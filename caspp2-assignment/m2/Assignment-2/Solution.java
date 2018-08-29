import java.util.Scanner;
/**.
    *@author: Gangadhar
    *rootsOfQuadraticEquation function.
*/
public final class Solution {
    /*
    Do not modify this main function.
    */
    private Solution() {
    }
    /**
    *@param args taking argument
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /*
    Need to write the rootsOfQuadraticEquation function and print the output.
    */
    /**
    *@param d int
    *@param b int
    *@param c int
    */
    public static void rootsOfQuadraticEquation(final int d, final int e, final int f) {
        double disc = (e * e) - (2 * 2 * d * f);
        double quad = Math.sqrt(disc);
        double root1 = (( -f + quad) / (2 * d));
        double root2 = (( -f - quad) / (2 * d));
        System.out.println(root1 + " " + root2);
    }
}
