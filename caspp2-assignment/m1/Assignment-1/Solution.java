import java.util.Scanner;

/**.
    *Date: 28/08/18.
    *Name: Gangadhar.
    *Printing roll number and name of students.
*/
public final class Solution {
    /**
    *printing roll number and name of students.
    */
    private Solution() {
        /**empty constructor.
        */
    }
    /**.
    * @param  args standard main parameters.
    */
    public static void main(final String[] args) {
        Scanner k = new Scanner(System.in);
        String name = k.nextLine();
        String roll = k.nextLine();
        System.out.println("name : " + name
            + ", roll Number : " + roll);
    }
}
