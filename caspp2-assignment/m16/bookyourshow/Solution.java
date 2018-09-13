import java.util.Scanner;
class Show {
	String movie;
	String showdate;
	String[] seatno;
	Show(String movie, String showdate, String[] seatno) {
	this.movie = movie;
	this.showdate = showdate;
	this.seatno = seatno;
	}

}
class BookYourShow {

	BookYourShow() {

	}
	private void addAShow() {

	}
	private void getAShow() {

	}
	private void bookAShow() {

	}
	private String printTickets() {
		return null;
	
}	private String showAll() {
		return null;
	}
}
class Patron {
	String patron;
	String mobno;
	Patron(String patron, String mobno) {
		this.patron = patron;
		this.mobno = mobno;
	}
}
class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
		String line = scan.next();
		String[] tokens = line.split(" ");
		switch (tokens[0]) {
			case "add":
				System.out.println("add");
				break;
			case "book":
				System.out.println("book");
				break;
			case "get":
				System.out.println("get");
				break;
			case "print":
				System.out.println("print");
				default:
			}
		}
	}
}