import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author :gangadharsingh
 */
class Set {
	//
	// your code goes here... Good luck :-)
	//
	/**
	*initializing integer.
	*/
	private int[] set;
	/**
	 *initializing integer. 
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	Set() {
		set = new int[10];
		size = 0;
	}
	/**
	 * 
	 * description.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return size;
	}

	/**
	 * { function_description }
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (set[i] == item) {
				return true;
			}
		}
		return false;
	}
	/**
	 * { function_description }
	 */
	public void resize() {
		set = Arrays.copyOf(set, size * 2);
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			str = str + set[i] + ", ";
		}
		str = str + set[i] + "}";
		return str;
	}
	/**
	 * { function_description }
	 *
	 * @param      item  The item
	 */
	public void add(final int item) {
		if (size == set.length) {
			resize();
		}
		if (!contains(item) && size > 0) {
			set[size++] = item;
		} else if (size == 0) {
			set[size++] = item;
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      array  The array
	 */
	public void add(final int[] array) {
		if (array.length + size > set.length) {
			resize();
		}
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
	}
	public int get(final int index) {
		if (index < 0 || index >= size) {
			return -1;
		} else {
			return set[index];
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      set2  The set 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Set intersection(final Set set2) {
		Set setIntersection = new Set();

		int[] array = new int[set2.size()];

		for (int i = 0; i < set2.size(); i++) {
			array[i] = set2.get(i);
		}
		
		for (int a: set) {
			for (int b: array) {
				if (a == b) {
					setIntersection.add(a);
					}
			}
			}
		return setIntersection;                                                                    

	}
	/**
	 * { function_description }
	 *
	 * @param      array  The array
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Set retainAll(final int[] array) {
		Set setIntersection = new Set();

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < array.length; j++) {

				if (set[i] == array[j]) {

					setIntersection.add(set[i]);
				}
			}
		}
		return setIntersection;
	}
	/**
	 * { function_description }
	 *
	 * @param      set2  The set 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int[][] cartesianProduct(final Set set2) {
		int[][] product = new int[size * set2.size()][2];
		int iterate = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < set2.size(); j++) {
				product[iterate][0] = set[i];
				product[iterate][1] = set2.get(j);
				iterate++;
			}
		}
		return product;
	}

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * helper function to convert string input to int array.
	 *
	 * @param      s     { string input from test case file }
	 *
	 * @return     { int array from the given string }
	 */
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
		}
		return Arrays.stream(input.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		//
		// instantiate this set
		//
		Set s = new Set();
		// code to read the test cases input file
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		while (stdin.hasNext()) {
			// read the line
			String line = stdin.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.contains(Integer.parseInt(tokens[1])));
				break;
			case "print":
				System.out.println(s);
				break;
			case "add":
				int[] intArray = intArray(tokens[1]);
				if (intArray.length == 1) {
					s.add(intArray[0]);
				} else {
					s.add(intArray);
				}
				break;
			case "intersection":
				s = new Set();
				Set t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(s.intersection(t));
				break;
			case "retainAll":
				s = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				System.out.println(s.retainAll(intArray));
				break;
			case "cartesianProduct":
				s = new Set();
				t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
				break;
			default:
				break;
			}
		}
	}
}
