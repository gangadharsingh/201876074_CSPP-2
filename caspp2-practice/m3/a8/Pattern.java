import java.util.Scanner;
/**.
    *@author: Gangadhar
    *Date:29/08/18
    *while loop.
*/
public final class Pattern {
    /**.
    *{using while loop}
    */
    private Pattern() {
    }
    /**.
    *{Do not modify this main function}.
    */
    /*private static final double NUM = 0.5;*/
    /**.
    *creating NUM variable
    */
    /**.
    *@param args taking argument
    */
    public static void main(final String[] args) {
        /**.
        *{using while loop}
        */
        Scanner inp = new Scanner(System.in);
        double i = inp.nextDouble();
        for (int j = 1; j <= i; j++) {
            for (int k = 1; k <= j; k++) {
            System.out.print(k);
        }
        System.out.println("\n");
        }
}
}
