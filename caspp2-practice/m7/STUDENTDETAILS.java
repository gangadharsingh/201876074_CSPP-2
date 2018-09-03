import java.util.Scanner;
/**
 * @author     gangadharsingh.
 */
public final class STUDENTDETAILS {
    /**
     * creating a magic number.
     */
    public static final int NUM = 10;
    /**
     * Constructs the object.
     */
    private STUDENTDETAILS() {
        /**
         * empty constructor.
         */
    }
    /**
     * Printing GPA of students.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Double stud1 = studentdata();
        Double stud2 = studentdata();
        Double stud3 = studentdata();
        System.out.printf("%.1f\n", stud1);
        System.out.printf("%.1f\n", stud2);
        System.out.println(Math.floor(stud3 * NUM) / NUM);
    }
    /**
     * taking student data.
     *
     * @return     { description_of_the_return_value }
     */
    public static Double studentdata() {
        Scanner scan =  new Scanner(System.in);
        String studname = scan.next();
        String studroll = scan.next();
        Double sub1 = scan.nextDouble();
        Double sub2 = scan.nextDouble();
        Double sub3 = scan.nextDouble();
        Student gpamark = new Student(studname, studroll, sub1, sub2, sub3);
        return gpamark.getGPA();
    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * declaring variables.
     */
    private String na;
    /**
     *  declaring variables.
     */
    private String ro;
    /**
     *  declaring variables.
     */
    private Double su1;
    /**
     *  declaring variables.
     */
    private Double su2;
    /**
     *  declaring variables.
     */
    private Double su3;
    /**
     * creating a magic number.
     */
    public static final int NUM1 = 3;
    /**
     * Constructs the object.
     *
     * @param      name      The name.
     * @param      rollno    The rollno.
     * @param      submark1  The submark 1.
     * @param      submark2  The submark 2.
     * @param      submark3  The submark 3.
     */
    Student(final String name, final String rollno, final Double submark1,
        final Double submark2, final Double submark3) {
        this.na = name;
        this.ro = rollno;
        this.su1 = submark1;
        this.su2 = submark2;
        this.su3 = submark3;
    }
    /**
     * Gets the gpa.
     *
     * @return     The gpa.
     */
    public Double getGPA() {
        return (su1 + su2 + su3) / NUM1;
    }
}
