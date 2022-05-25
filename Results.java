import java.util.Date;
public class Results {
   private String userName;
    private Date testDate;
    private int testScore;

    public Results(String name, Date testDate, int testScore) {
        this.userName = name;
        this.testDate = testDate;
        this.testScore = testScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }


    public void DisplayResults(){

        System.out.println( this.userName + " got the score of " + this.testScore + " out of 5 on " + this.testDate);

    }


}
