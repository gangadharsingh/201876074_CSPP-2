import java.util.Scanner;
/**
 *@author gangadharsingh.
 * Bigger and smaller number.
 */
final class Biggerequalsmaller {
    /**.
     * Constructs the object.
     */
    private Biggerequalsmaller() {
        //not used
    }
    /**
     * main funtion.
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a > b) {
            System.out.println("Bigger");
        } else if (b > a) {
            System.out.println("Smaller");
        } else {
            System.out.println("Equal");
        }
    }
}
