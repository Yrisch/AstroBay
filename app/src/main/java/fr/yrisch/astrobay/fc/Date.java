package fr.yrisch.astrobay.fc;

public class Date {

    private  double year;
    private  double month;
    private  double day ;
    private  double hour;
    private  double minute;
    private  double second;


    public Date(){
        //default constructor
    }


    //mutateur


    public double getYear() {
        return year;
    }

    public double getMonth() {
        return month;
    }

    public double getDay() {
        return day;
    }

    public double getHour() {
        return hour;
    }

    public double getMinute() {
        return minute;
    }

    public  double getSecond() {
        return second;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public void setMonth(double month) {
        this.month = month;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public void setMinute(double minute) {
        this.minute = minute;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public void setDate(double year,double month,double day){
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

}
