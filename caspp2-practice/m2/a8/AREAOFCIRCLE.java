import java.util.Scanner;
/**
 *@author gangadharsingh.
 * Write a java program to replace each element.
 *  of the given char array that matches the given.
 *  character with the given replacement.
 */
final class AREAOFCIRCLE {
    /**.
     * Constructs the object.
     */
    private AREAOFCIRCLE() {
        //not used
    }
    /**
     * {creating PI variable}.
     */
    public static final double PI = 3.14;
    /**
     * main funtion.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int radius = scan.nextInt();
        System.out.println(PI * (radius ^ 2));
    }
}
