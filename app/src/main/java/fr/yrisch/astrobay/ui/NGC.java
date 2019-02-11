package fr.yrisch.astrobay.ui;

import android.media.Image;

public class NGC {
    private int Icon;
    private String ngcId;
    private String ngcCoor;

    public NGC(int Icon, String ngcId,String ngcCoor){
        this.Icon = Icon;
        this.ngcId = ngcId;
        this.ngcCoor = ngcCoor;
    }

    public int getIcon() {
        return Icon;
    }

    public String getNgcCoor() {
        return ngcCoor;
    }

    public String getNgcId() {
        return ngcId;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public void setNgcCoor(String ngcCoor) {
        this.ngcCoor = ngcCoor;
    }

    public void setNgcId(String ngcId) {
        this.ngcId = ngcId;
    }
}
