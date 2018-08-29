/**.
    *@author: Gangadhar
    *Date:29/08/18
    *while loop.
*/
public final class ConvertToWhileLoop {
    /**.
    *{using while loop}
    */
    private ConvertToWhileLoop() {
    }
    /**.
    *{Do not modify this main function}.
    */
    private static final int NUM = 11;
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
        int i = 2;
        while (i < NUM) {
            System.out.println(i);
            i = i + 2;
        }
    System.out.println("GoodBye!");
}
}
