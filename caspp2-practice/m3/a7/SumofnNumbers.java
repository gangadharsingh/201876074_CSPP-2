import java.util.Scanner;
/**.
    *@author: Gangadhar
    *Date:29/08/18
    *while loop.
*/
public final class SumofnNumbers {
    /**.
    *{using while loop}
    */
    private SumofnNumbers() {
    }
    /**.
    *{Do not modify this main function}.
    */
    private static final double NUM = 0.5;
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
        System.out.println((i * (i + 1)) * NUM);
}
}
