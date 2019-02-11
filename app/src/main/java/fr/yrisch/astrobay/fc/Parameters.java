package fr.yrisch.astrobay.fc;

import static java.lang.Math.*;

public class Parameters {

    private double alphaH;
    private double alphaT;
    private HeureSiderale HS;
    private Date date;

    public Parameters(){

    }

    private void calculatealphaT() {

        alphaT = (date.getHour() - 13 + date.getMinute()/60) * 2 * PI/(23+0.93333+0.00388889);
    }

    private void calculatealphaH() {

        alphaH =  (2 * PI *HS.getHS())/ (23+0.93333+0.00388889);

    }

    public double getAlpha(){
        calculatealphaH();
        calculatealphaT();
        return alphaH+alphaT;
    }
}
