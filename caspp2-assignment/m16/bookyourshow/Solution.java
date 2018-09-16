import java.util.Scanner;
/**
 * Class for show.
 * @author: gangadharsingh.
 */
class Show {
    /**
     * Show type.
     */
    private String moviename;
    /**
     * timedate of string type.
     */
    private String timedate;
    /**
     * String array seats.
     */
    private String[] seats;
    /**
     * Constructs the object.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     * @param      c     { parameter_description }.
     */
    Show(final String a, final String b, final String[] c) {
        this.moviename = a;
        this.timedate = b;
        this.seats = c;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public String getmoviename() {
        return moviename;
    }
    /**
     * { function_description }.
     *
     * @param      mn    { parameter_description }.
     */
    public void setmoviename(final String mn) {
        moviename = mn;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public String gettimedate() {
        return timedate;
    }
    /**
     * { function_description }.
     *
     * @param      td    { parameter_description }.
     */
    public void settimedate(final String td) {
        timedate = td;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public String[] getseats() {
        return seats;
    }
    /**
     * { function_description }.
     *
     * @param      st    { parameter_description }.
     */
    public void setseats(final String[] st) {
        seats = st;
    }
}
/**
 * Class for patron.
 */
class Patron {
    /**
     * String variable.
     */
    private String patronname;
    /**
     * String type variable.
     */
    private String mobilenumber;
    /**
     * Constructs the object.
     *
     * @param      a     {patron name}.
     * @param      b     {patron mobile no.}.
     */
    Patron(final String a, final String b) {
        this.patronname = a;
        this.mobilenumber = b;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getpatronname() {
        return patronname;
    }
    /**
     * { function_description }.
     *
     * @param      pn    { parameter_description }.
     */
    public void setpatronname(final String pn) {
        patronname = pn;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public String getmobilenumber() {
        return mobilenumber;
    }
    /**
     * { function_description }.
     *
     * @param      mn    { parameter_description }.
     */
    public void setmobilenumber(final String mn) {
        mobilenumber = mn;
    }
}
/**
 * Class for BookYourShow.
 */
class BookYourShow {
    /**
     * int number.
     */
    public static final int LEN = 10;
    /**
     * initializing variable.
     */
    private Show[] movielist;
    /**
     * Patron array type.
     */
    private Patron[] patronlist;
    /**
     * integer type size.
     */
    private int size = 0;
    /**
     * integer variable.
     */
    private int patronsize = 0;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        this.movielist = new Show[LEN];
        this.patronlist = new Patron[LEN];
        this.size = 0;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int getsize() {
        return size;
    }
    /**
     * { function_description }.
     *
     * @param      sz    The size.
     */
    public void setsize(final int sz) {
        size = sz;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int getpatronsize() {
        return patronsize;
    }
    /**
     * { function_description }.
     *
     * @param      ps    { parameter_description }.
     */
    public void setpatronsize(final int ps) {
        patronsize = ps;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public Patron[] getpatronlist() {
        return patronlist;
    }
    /**
     * { function_description }.
     *
     * @param      pl    { parameter_description }.
     */
    public void setpatronlist(final Patron[] pl) {
        for (int i = 0; i < pl.length; i++) {
            patronlist[patronsize++] = pl[i];
        }
    }
    /**
     * Adds a show.
     *
     * @param      k     { parameter_description }.
     */
    public void addAShow(final Show k) {
        movielist[size++] = k;
    }
    /**
     * Gets a show.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     A show.
     */
    public Show getAShow(final String a, final String b) {
        for (int i = 0; i < size; i++) {
            if ((movielist[i].getmoviename()).equals(a)) {
                if ((movielist[i].gettimedate()).equals(b)) {
                    return movielist[i];
                }
            }
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     * @param      c     { parameter_description }.
     * @param      d     { parameter_description }.
     */
    public void bookAShow(final String a,
                          final String b, final Patron c, final String[] d) {
        int cnt = 0;
        if (size == 0) {
            System.out.println("No show");
        } else {

            for (int k = 0; k < size; k++) {
                if (a.equals(movielist[k].getmoviename())) {
                    if ((movielist[k].gettimedate()).equals(b)) {
                        String[] availseats = movielist[k].getseats();
                        for (int i = 0; i < d.length; i++) {
                            for (int j = 0; j < availseats.length; j++) {
                                if (availseats[j].equals(d[i])) {
                                    availseats[j] = "N/A";
                                    cnt += 1;
                                }

                            }

                        }
                        if (cnt > 0) {
                            patronlist[patronsize] = c;
                            patronsize++;
                        }
                    } else {
                        System.out.println("No show");
                        break;
                    }

                }
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     * @param      c     { parameter_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean printTicket(final String a, final String b, final String c) {
        for (int i = 0; i < patronsize; i++) {
            if (c.equals(patronlist[i].getmobilenumber())) {
                for (int j = 0; j < size; j++) {
                    if (b.equals(movielist[j].gettimedate()) && a.equals(
                                movielist[j].getmoviename())) {
                        System.out.println(patronlist[
                                i].getmobilenumber() + " " + a + " " + b);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Shows all.
     */
    public void showAll() {
        if (movielist.length > 0) {
            for (int i = 0; i < size; i++) {
                String str = "";
                str += movielist[i].getmoviename() + ",";
                str += movielist[i].gettimedate() + ",";
                String str2 = "[";
                String[] availseats = movielist[i].getseats();
                for (int j = 0; j < availseats.length - 1; j++) {
                    str2 += availseats[j] + ",";
                }
                str2 += availseats[availseats.length - 1] + "]";
                str += str2;
                System.out.println(str);
            }
        }
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * empty.
         */
    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(check[1] + "," + tokens[1]);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                if (bys.printTicket(check[1], tokens[1], tokens[2])) {
                    break;
                } else {
                    System.out.println("Invalid");
                }
                break;

            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}
