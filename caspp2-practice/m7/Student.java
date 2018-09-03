public class Student {
	private String Name;
	private String Rollno;
	private Double SubMark1;
	private Double SubMark2;
	private Double SubMark3;
	public Student(String Name, String Rollno, Double SubMark1, Double SubMark2, Double SubMark3) {
		this.Name = Name;
		this.Rollno = Rollno;
		this.SubMark1 = SubMark1;
		this.SubMark2 = SubMark2;
		this.SubMark3 = SubMark3;
	}
	public Double getGPA() {
		return (SubMark1 + SubMark2 + SubMark3) / 3;
	}
}

