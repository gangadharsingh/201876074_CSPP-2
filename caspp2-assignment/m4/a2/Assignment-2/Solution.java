import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int[][] matrix1 = takingInput(createMatrix(a, b), scan);
        a = scan.nextInt();
        b = scan.nextInt();
        int[][] matrix2 = takingInput(createMatrix(a, b), scan);
        addMatrix(matrix1, matrix2);
    }

    /**
     * Creates a matrix.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] createMatrix(final int a, final int b) {
        return new int[a][b];
    } 

    /**
     * { function_description }
     *
     * @param      matrix  The matrix
     * @param      scan    The scan
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] takingInput(final int[][] matrix, final Scanner scan) {
        for (int i = 0; i < getRowSize(matrix) ;i++ ) {
            for (int j = 0; j < getColumnSize(matrix);j++ ) {
                matrix[i][j] = scan.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Adds a matrix.
     *
     * @param      matrix1  The matrix 1
     * @param      matrix2  The matrix 2
     */
    public static void addMatrix(final int[][] matrix1, final int[][] matrix2) {
        if (getRowSize(matrix1) == getRowSize(matrix2) && 
                getColumnSize(matrix1) == getColumnSize(matrix2)) {
            int[][] sumMatrix = createMatrix(getRowSize(matrix1), getColumnSize(matrix1));
            for (int i = 0; i < getRowSize(sumMatrix) ;i++ ) {
                for (int j = 0;j < getColumnSize(sumMatrix) ;j++ ) {
                    sumMatrix[i][j] += matrix2[i][j] + matrix1[i][j];
                }
            }
            System.out.println(printMatrix(sumMatrix));
        } else {
            System.out.println("not possible");
        }
    }

    /**
     * Gets the row size.
     *
     * @param      matrix  The matrix
     *
     * @return     The row size.
     */
    public static int getRowSize(final int[][] matrix) {
        return matrix.length;
    }

    /**
     * Gets the column size.
     *
     * @param      matrix  The matrix
     *
     * @return     The column size.
     */
    public static int getColumnSize(final int[][] matrix) {
        return matrix[0].length;
    }

    /**
     * { function_description }
     *
     * @param      matrix  The matrix
     *
     * @return     { description_of_the_return_value }
     */
    public static String printMatrix(final int[][] matrix) {
        String temp = "";
        for (int i = 0;i < getRowSize(matrix) ;i++ ) {
            for (int j = 0;j < getColumnSize(matrix) ;j++ ) {
                temp += matrix[i][j] + " ";
            }
            temp = temp.trim();
            temp += "\n";
        }
        return temp;
    }
}
