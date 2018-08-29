import java.util.Scanner;
/**.
    *@author: Gangadhar
    *rootsOfQuadraticEquation function.
*/
public final class Solution {
	/*
	Do not modify this main function.
	*/
	private Solution() {
    }
    /**
	*@param args taking argument
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	/**
	*@param a int
	*@param b int
	*@param c int
	*/
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		double n = (b * b) - (2 *2 * a * c);
		double quad = Math.sqrt(n);
		double root1 = (( c + quad) / (2 * a));
		double root2 = (( c - quad) / (2 * a));
		System.out.println(root1 + " " + root2);
	}
}
