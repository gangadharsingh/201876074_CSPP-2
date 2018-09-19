public class Foodlog {
    private String foodname;
    private String foodquantity;
    private String date;
    private String time;

    Foodlog() {
    }

    Foodlog(String[] food) {
        foodname = food[0];
        foodquantity = food[1];
        date = food[2];
        time = food[3];
    }

    public String getfoodname() {
        return foodname;
    }
    public void setfoodname(String foodname) {
        foodname = foodname;
    }

    public String getfoodquantity() {
        return foodquantity;
    }
    public void setfoodquantity(String foodquantity) {
        foodquantity = foodquantity;
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
        return "Date:" + date + "\n" +
               "Time:" + time + "\n" + "Name:" + foodname + "\n" +
               "Quantity:" + foodquantity;
    }

}