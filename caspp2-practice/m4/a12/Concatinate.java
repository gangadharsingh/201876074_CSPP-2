import java.util.Scanner;
/**
 *@author gangadharsingh.
 * Concatenate of string.
 */
final class Concatinate {
    /**.
     * Constructs the object.
     */
    private Concatinate() {
        //not used
    }
    /**
     * main funtion.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println("Hello " + str + '!');
    }
}
