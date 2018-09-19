public class PhysicalActivity {

    private String date;
    private String activityname;
    private String startime;
    private String endtime;
    private String note;

    PhysicalActivity() {
    }

    PhysicalActivity(String[] activity) {
        activityname = activity[0];

        /*        if (activity.length == 5) {*/
        note = activity[1];
        date = activity[2];
        startime = activity[3];
        endtime = activity[4];
        /*        } else {
                    date = activity[1];
                    startime = activity[2];
                    endtime = activity[3];
                }*/
    }

    public String getactivityname() {
        return activityname;
    }
    public void setactivityname(String activitynm) {
        activityname = activitynm;
    }

    public String getdate() {
        return date;
    }
    public void setdate(String dt) {
        date = dt;
    }

    public String getstartime() {
        return startime;
    }
    public void setstartime(String starttm) {
        startime = starttm;
    }

    public String getendtime() {
        return endtime;
    }
    public void setendtime(String endtm) {
        endtime = endtm;
    }

    public String getnote() {
        return note;
    }
    public void setnote(String nt) {
        note = nt;
    }

    public String toString() {
        /*        if (note != null) {*/
        return "Name:" + activityname +
               "\n" + "Notes:" + note + "\n" +
               "Date:" + date + "\n" +
               "Starttime:" + startime + "\n" +
               "Endtime:" + endtime;
        /* }
         return "PhysicalActivity" + "\n" + "Name:" + activityname + "\n" + "Date:" + date +
                "\n" + "Starttime:" + startime + "\n" + "Endtime:" + endtime;*/
    }
}