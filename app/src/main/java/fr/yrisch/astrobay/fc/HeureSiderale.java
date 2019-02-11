package fr.yrisch.astrobay.fc;

import static java.lang.Math.*;


public class HeureSiderale {
    private double HS;
    private JourJulien Jourj;

    public HeureSiderale(){
        calculateHS();
    }



    public void calculateHS(){
        double nbS;
        double HSH;
        nbS = (Jourj.getJJ()- 2451545 ) / 36525;
        HSH = 24110.54841 + ( 8640184.812866 * nbS) + ( 0.093104 *pow(nbS,2)) - (0.0000062 *pow(nbS,3) )/3600;
        HS = (( HSH / 24 ) - floor( HSH / 24 ))*24;

    }

    public double getHS() {
        return HS;
    }
}
