import java.util.Scanner;
/**
 *@author gangadharsingh.
 * Class for average.
 */
final class Average {
	/**
	 *class Average.
	 */
	public static final Scanner s = new Scanner(System.in);
	/**
	 * Constructs the object.
	 */
	private Average() {
		/**
		 * empty constructor.
		 */
	}
	/**
	 * Creates an array.
	 * @param      size  The size.
	 * @return     {returning integer array}.
	 */
	public static int[] createArray(int size) {
		int[] number = new int[size];
		for (int i = 0; i < size; i++) {
			number[i] = s.nextInt();
		}
		return number;
	}
	/**
	 * Calculates the average.
	 * @param      size  The size.
	 * @param      list  The list.
	 * @return     The average.
	 */
	public static double calculateAverage(int size, int[] list) {
		double average = 0;
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += list[i];
		}
		average = sum / size;
		return average;

	}
	/**
	 *calculating average of given number.
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		int size = s.nextInt();
		int[] list = createArray(size);
		double res = calculateAverage(size, list);
		System.out.println(res);
	}
}