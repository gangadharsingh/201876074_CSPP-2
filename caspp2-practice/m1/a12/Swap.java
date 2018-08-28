/**.
    *Date: 28/08/18.
    *Name: Gangadhar.
    *Swapping two number.
*/
final class Swap {
    /**.
    * private constructor
    **/
    public static final int NUM1 = 2;
    /**
    *calculating quotient and remainder.
    */
    public static final int NUM2 = 3;
    /**
    *calculating quotient and remainder.
    */
    private Swap() {
    /**
    */
    }
    /**.
    * @param  args standard main parameters
    */
    public static void main(final String[] args) {
        int var1 = NUM1, var2 = NUM2, temp;
        temp = var1;
        var1 = var2;
        var2 = temp;
        System.out.println(var1);
        System.out.println(var2);
    }
}
