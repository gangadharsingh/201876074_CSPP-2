import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : gangadharsingh
 */
final class Solution {
    /**
     * Constructs the object.
     */
    public static final int NUM1 = 100;
    public static final int NUM2 = 50;
    public static final int NUM3 = 10;
    public static final int NUM4 = 5;
    private Solution() {
        //not used
    }
    /**
     * Function to round the elements of a matrix to the nearest 100.
     *
     * @param      a        Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns  Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
        final int rows, final int columns) {

    // write ypur code here
    int[][] round = new int[rows][columns];
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
            if (a[i][j] / NUM1 > 0) {
                if (a[i][j] % NUM1 >= NUM2) {
                    round[i][j] = ((a[i][j] / NUM1) + 1) * NUM1;
                } else {
                    round[i][j] = (a[i][j] / NUM1) * NUM1;
                }
            } else if (a[i][j] / NUM3 >= NUM4) {
                round[i][j] = NUM1;
            } else {
                round[i][j] = 0;
            }
        }
        }
        return round;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
