public class Sleeplog {
    private String date;
    private String datestartime;
    private String datendtime;

    Sleeplog() {
    }

    Sleeplog(String[] sleep) {
        date = sleep[0];
        datestartime = sleep[1];
        datendtime = sleep[2];
    }

     public String getstartime(){
      return datestartime;
     }     
     public void setstartime(String dtstrtime){
      datestartime = dtstrtime;
     }

    public String getendtime(){
      return datendtime;
     }
     public void setendtime(String dtendtime){
      datendtime = dtendtime;
     }
     public String getdate() {
        return date;
    }
    public void setdate(String dt) {
        date = dt;
    }
    public String toString() {
      return "Date:"+date+"\n"+"Starttime:"+datestartime + "\n"+"Endtime:" + datendtime;
    }
}