import java.util.Scanner;
/**
 * @author     gangadharsingh.
 */
public final class tudentDetails {

    private studentDetails() {
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
        Student stud1 = new Student("Sangay", "IT201985001", 7.5, 7.0, 8.0);
        Student stud2 = new Student("Bidhya", "IT201985003", 8.5, 6.0, 7.5);
        Student stud3 = new Student("Kelzang", "IT201985065", 7.5, 8.0, 9.0);
        System.out.printf("%.1f\n", stud1);
        System.out.printf("%.1f\n", stud2);
        System.out.printf("%.1f\n", stud3);
    }
}
/**
 * Class for student.
 */
class Student {
    private String Name;
    private String Rollno;
    private Double SubMark1;
    private Double SubMark2;
    private Double SubMark3;
    public Student(String Name, String Rollno, Double SubMark1,
        Double SubMark2, Double SubMark3) {
        this.Name = Name;
        this.Rollno = Rollno;
        this.SubMark1 = SubMark1;
        this.SubMark2 = SubMark2;
        this.SubMark3 = SubMark3;
    }
    /**
     * Gets the gpa.
     *
     * @return     The gpa.
     */
    public Double getGPA() {
        return (SubMark1 + SubMark2 + SubMark3) / 3;
    }
}
