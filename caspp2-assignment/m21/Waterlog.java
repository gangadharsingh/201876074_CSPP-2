public class Waterlog {

    private String date;
    private String waterquantity;
    private String time;

    Waterlog() {
    }

    Waterlog(String[] water) {
        waterquantity = water[0];
        date = water[1];
        time = water[2];
    }

    public String getwaterquantity() {
        return waterquantity;
    }
    public void setwaterquantity(String waterquantity) {
        waterquantity = waterquantity;
    }

    public String getdate() {
        return date;
    }
    public void setdate(String dt) {
        date = dt;
    }

    public String gettime() {
        return time;
    }
    public void settime(String tm) {
        time = tm;
    }

    public String toString() {
        return "Date:" + date +
               "\n" + "Quantity:" + waterquantity + "ml";
    }

}