import java.util.Scanner;
/**
 *comparing array.
 *@author gangadharsingh.
 */
public final class FirstLast6 {
    /**
     * Constructs the object.
     */
    public static final int NUM = 6;
    /**
     *declaring number.
     */
    private FirstLast6() {
        /**
         * empty constructor.
         */
    }
    /**
     *main function.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] arr = new int[num];
        arr = createarray(num, s);
        System.out.println(checkarray(arr, num));

    }
    /**
     * {creating array}.
     *
     * @param      num   The number.
     * @param      s     {scanner object}.
     * @return     {array of one dimension}.
     */
    public static int[] createarray(final int num, final Scanner s) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }
    /**
     * {checking array}.
     * @param      arr   The arr.
     * @param      num   The number.
     * @return     {true or false}.
     */
    public static boolean checkarray(final int[] arr, final int num) {
        return (arr[0] == NUM || arr[num - 1] == NUM);
    }
}
