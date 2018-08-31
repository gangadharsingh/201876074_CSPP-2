import java.util.Scanner;
/**.
*@author: Gangadhar
*print maximum of given array.
*/
 
import java.util.*;
public final class Solution {/*
    Fill this main function to print maximum of given array
    */
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] matrix = new int [a];
        for (int i = 0; i < a; i++) {
            matrix[i] = sc.nextInt();
        }
        System.out.println(matrix[a-1]);
    }
}