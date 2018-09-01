import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers.
 * between 2 and n where n is given as an input.
 *
 * @author : gangadharsingh
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    public static final int NUM = 5;
    /**
     * Constructs the object.
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
        long[] arr = new long[n];
        int cnt = 0;
        for (long i = NUM; i <= n; i++) {
            for (long j = 2; j < i; j++) {
                if (i % 2 != 0 && i % j == 0) {
                    arr[cnt] = i;
                    cnt++;
                }
            }
        }
        int cntelem = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[cntelem]) {
                System.out.println(arr[i]);
            }
            if (cntelem == arr.length) {
                break;
            }
            cntelem++;
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

