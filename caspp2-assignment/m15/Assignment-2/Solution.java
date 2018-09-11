import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 *@author : gangadharsingh.
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * empty constructor.
         */
    }
    /**
     * creating Solution function.
     *
     * @param      s     object of String.
     *
     * @return     {int array}.
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(",")).mapToInt(
                   Integer::parseInt).toArray();
    }

    /**
     * main function.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
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
                try {
                    System.out.println(s.last());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "print":
                System.out.println(s);
                break;
            case "headSet":
                try {
                    intArray = intArray(tokens[1]);
                    if (intArray.length == 1) {
                        System.out.println(Arrays.toString(s.headSet(
                                        intArray[0])).replace("[", "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "intersection":
                SortedSet set = new SortedSet();
                SortedSet set2 = new SortedSet();
                intArray = intArray(tokens[1]);
                set.addAll(intArray);
                intArray = intArray(tokens[2]);
                set2.addAll(intArray);
                System.out.println(set.intersection(set2));
                break;
            case "retainAll":
                set = new SortedSet();
                intArray = intArray(tokens[1]);
                set.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(set.retainAll(intArray));
                break;
            case "subSet":
                try {
                    String[] t = tokens[1].split(",");
                    int[] n = s.subSet(Integer.parseInt(
                                           t[0]), Integer.parseInt(t[1]));
                    if (n.length != 1) {
                        System.out.println(Arrays.toString
                            (n).replace("[", "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
            }
        }
    }
}
/**
 * Class for sorted set.
 */
class SortedSet extends Set {

    /**
     * return subset.
     *
     * @param      fromElement  The from element.
     * @param      toElement    To element.
     *
     * @return     { return integer array }.
     *
     * @throws     Exception    invalid argument to index.
     */
    public int[] subSet(final int fromElement,
                        final int toElement) throws Exception {
        if (fromElement > toElement) {
            throw new Exception("Invalid Arguments to Subset Exception");
        } else {
            int count = 0;
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                if (set[i] >= fromElement && set[i] < toElement) {
                    temp[count++] = set[i];
                }
            }
            int[] subset = new int[count];
            for (int i = 0; i < count; i++) {
                subset[i] = temp[i];
            }
            return subset;
        }
    }

    /**
     * return element upto toelement.
     *
     * @param      toElement  To element.
     *
     * @return     { int array }.
     *
     * @throws     Exception  empty set exception.
     */
    public int[] headSet(final int toElement)throws Exception {
        int count = 0;
        int[] temp = new int[size];
        if (size == 0 || toElement <= set[0]) {
            throw new Exception("Set Empty Exception");
        } else {
            for (int i = 0; i < size; i++) {
                if (set[i] < toElement) {
                    temp[count++] = set[i];
                }
            }
            int[] headset = new int[count];
            for (int i = 0; i < count; i++) {
                headset[i] = temp[i];
            }
            return headset;
        }
    }
    /**
     * the funciton will return last element of sorted set.
     *
     * @return     {last element}.
     *
     * @throws     Exception  empty set exception.
     */
    public int last() throws Exception {
        if (size <= 0) {
            throw new  Exception("Set Empty Exception");
        } else {
            return set[size - 1];
        }
    }
    /**
     * Adds all.
     *
     * @param      array  The array
     */
    public void addAll(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
        // set = Arrays.copyOf(set, size);
        Arrays.sort(set, 0, size());
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
}
