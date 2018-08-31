/**.
 * @author: gangadharsingh
 */

// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
public class Solution {
    /** . Do not modify this main function.
     * @param args argument.
     */
    public final static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);//Write binaryToDecimal function
            System.out.println(res);
        }
    }

    /**
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static String binaryToDecimal(String s) {
        int num = 0;
        String l = "";
        char[] arr = s.toCharArray();
        int k = arr.length - 1;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '1') {
                num += Math.pow(2, k);
            }
            k--;
        }
        l += num;
        return l;
    }
}
