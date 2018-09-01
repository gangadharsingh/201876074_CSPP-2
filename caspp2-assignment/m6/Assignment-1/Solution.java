import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
    // write your code here
        int[] arr = new int[n/2];
        int cnt = 0;
        for (int num = 2; num <= n; num++) {
            for (int div = 2; div < num; div++) {
                if (num % div == 0) {
                    cnt++;
                }
            }
            if (cnt > 2) {
                if (num % 2 != 0) {
                    System.out.println(num);
                }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

