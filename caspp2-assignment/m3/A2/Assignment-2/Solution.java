import java.util.Scanner;
/**.
    *@author: Gangadhar
    *Date:29/08/18
    *wnumber of 7's in between 1 to n.
*/
public final class Solution {
    /** Fill the main function to print the number of 7's between 1 to n.
    *{using while and for loop}
    */
    private Solution() {
    }
    /**.
    *{main function}
    */
    private static final int NUM = 7;
    private static final int NUM2 = 7;
    /**.
    *creating NUM variable
    */
    /**.
    *@param args taking argument
    */
    public static void main(final String[] args) {
        /**.
        *main function.
        */

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k > 0) {
                if (k % NUM2 == NUM) {
                    count = count + 1;
                }
                k = k / NUM2;

            }

        }
        System.out.println(count);
    }
}
