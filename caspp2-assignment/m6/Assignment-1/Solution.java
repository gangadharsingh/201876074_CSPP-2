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
        int[] arr = new int[n];
        int cnt = 0;
        for (int i = 5; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % 2 != 0 && i % j == 0) {
                    arr[cnt] = i;
                    cnt++; 
                }
            }
        }
        int cntelem = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[cntelem]) {
                System.out.println(arr[i]);
            }
            if (cntelem == arr.length || i == (arr.length - 1)) {
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

