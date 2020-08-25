package com.sachin.expandablerecyclerview;

public class Capitals
{
    String country;
    int images_flag;
    String capital;
    boolean expand;

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public Capitals(String country, int images_flag, String capital) {
        this.country = country;
        this.images_flag = images_flag;
        this.capital = capital;
        this.expand=false;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImages_flag() {
        return images_flag;
    }

    public void setImages_flag(int images_flag) {
        this.images_flag = images_flag;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
