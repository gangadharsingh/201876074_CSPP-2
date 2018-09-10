import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
public class Solution {

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

	public static void main(String[] args) {
		SortedSet s = new SortedSet();
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
            case "last":
                System.out.println(s.last());
                break;
            case "addAll":
            	int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "print":
                System.out.println(s);
                break;
            case "headSet":
                intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    System.out.println(Arrays.toString(s.headSet(intArray[0])).replace("[", "{").replace("]", "}"));
                }
                break;
            case "subSet":
/*                intArray = intArray(tokens[0]);
                intArray = intArray(tokens[1]);*/
                String[] t = tokens[1].split(",");
                s.subSet(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
                break;
			}
		}
	}
}
class SortedSet extends Set {
	public int[] subSet(int fromElement, int toElement) {
		int[] subset = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (set[i] >= fromElement && set[i] < toElement) {
				subset[count] = set[i];
			}
		}
		return subset;
	}
	public int[] headSet(int toElement) {
		int[] headset = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (set[i] < toElement) {
				headset[count++] = set[i];
			}
		}
		return headset;
	}
	public int last() {
		if (size == 0) {
			System.out.println("Set​ ​ Empty​ ​ Exception");
			return -1;
		} else {
			return set[size];
		}
	}
	public void addAll(int[] array) {
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
	}
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
}
