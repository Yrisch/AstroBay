package fr.yrisch.astrobay.fc;

import static java.lang.Math.*;


public class JourJulien {
    private double JJ;
    private Date date;


    public JourJulien(){
        date.setDate(0,0,0);
        calculateJJ();

    }

    public void checkMonth(){
        double localMonth;
        double localYear;
        if(date.getMonth()<3){
            localMonth = date.getMonth()+12;
            localYear = date.getYear()-1;
        }
    }

    public void calculateJJ(){
        double A;
        double B;
        double C;
        double D;
        A = floor(date.getYear()/100);
        B = 2-A+ceil(A/4);
        C = floor(date.getYear()*365.25);
        D = floor(30.6001*(date.getMonth()+1));
        JJ = B+C+D+date.getDay()+1720994.5;
    }

    public double getJJ() {
        return JJ;
    }
}
