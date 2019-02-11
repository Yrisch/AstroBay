package fr.yrisch.astrobay.fc;

import static java.lang.Math.*;
public class Starfinder {
    private Parameters param;
    private double longi;
    private double lat;
    private double dec;
    private double Hau;
    private double Az;
    private double H;
    private double asc;
    private double coordinates[];

    public Starfinder(){
        setStar(0,0);
        H = param.getAlpha()-asc+longi;
        calculateAz();
        calculateHau();
        coordinates = new double[]{Hau, Az};

    }

    public void calculateHau(){
        double sinushauteur;
        sinushauteur = sin(dec) * sin(lat) - cos(dec) * cos(lat) * cos(H);
        Hau = asin(sinushauteur);
    }

    public void calculateAz(){
        double cosazimuth;
        cosazimuth = ( sin(dec) - sin(lat) * sin(Hau) ) / ( cos(lat) * cos(Hau) );
        Az = +acos(cosazimuth);
    }


    private void setStar(double DecS,double AscS){
        dec = DecS;
        asc = AscS;

    }
    private void setPos(double Longi,double Lat){
        lat = Lat;
        longi = Longi;
    }
}
