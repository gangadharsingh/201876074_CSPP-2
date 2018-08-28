/**.
    *Date: 28/08/18.
    *Name: Gangadhar.
    *Remainder calculation
*/
public final class Quotientremainder {
    /**
    *calculating quotient and remainder.
    */
    public static final int NUM1 = 3;
    /**
    *calculating quotient and remainder.
    */
    public static final int NUM2 = 5;
    /**
    *calculating quotient and remainder.
    */
    private Quotientremainder() {
        /**empty constructor.
        */
    }
    /**.
    * @param  args standard main parameters
    */
    public static void main(final String[] args) {
        int a = NUM1;
        int b = NUM2;
        System.out.println("Quotient is: " + a / b);
        System.out.println("Remainder is: " + a % b);

    }
}
