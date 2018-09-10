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
            //System.out.println(tokens[0]+"tokens[0]");
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
				/*intArray = intArray(tokens[0]);
                intArray = intArray(tokens[1]);*/
                String[] t = tokens[1].split(",");
                int[] n = s.subSet(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
                if (n.length != 1) {
                	System.out.println(Arrays.toString(s.subSet(Integer.parseInt(t[0]), Integer.parseInt(t[1]))).replace("[", "{").replace("]", "}"));
                }
                break;
			}
		}
	}
}
class SortedSet extends Set {

	public int[] subSet(int fromElement, int toElement) {
		if (fromElement > toElement) {
			System.out.println("Invalid Arguments to Subset Exception");
			return new int[]{-1};
		}
		int[] temp = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (set[i] >= fromElement && set[i] < toElement) {
				temp[count++] = set[i];
			}
		}
		int[] subset = new int[count];
		for (int i = 0; i < count;i++ ) {
			subset[i] = temp[i];
		}
		return subset;
	}
	public int[] headSet(int toElement) {
		int count = 0;
		int[] temp = new int[size];
		for (int i = 0; i < size; i++) {
			if (set[i] < toElement) {
				temp[count++] = set[i];
			}
		}
		int[] headset = new int[count];
		for (int i = 0; i < count ;i++ ) {
			headset[i] = temp[i];
		}
		return headset;
	}
	public int last() {
		if (size == 0) {
			System.out.println("Set Empty Exception");
			return -1;
		} else {
			return set[size -1];
		}
	}
	public void addAll(int[] array) {
		for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
		Arrays.sort(set);
		super.toString();
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
