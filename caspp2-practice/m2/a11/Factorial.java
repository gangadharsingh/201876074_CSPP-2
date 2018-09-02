import java.util.Scanner;
/**
 * @author     gangadharsingh.
 * Factorial of a number.
 */
final class Factorial {
    /**
     * @param      num   The number
     * @return     {integer value}.
     */
    public static int factorial(final int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);

    }
    /**
     * Constructs the object.
     */
    private Factorial() {
        //not used
    }
    /**
     * main funtion.
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(factorial(num));
    }
}
