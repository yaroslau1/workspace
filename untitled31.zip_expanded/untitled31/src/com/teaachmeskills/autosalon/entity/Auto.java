package com.teaachmeskills.autosalon.entity;

/**
 * Created by TMS on 24.04.2018.
 */
public class Auto {
    private String marka;
    private int speed;
    private int price;

    public Auto(String marka, int speed, int price) {
        this.marka = marka;
        this.speed = speed;
        this.price = price;
    }

    public Auto(){

    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    public String toString() {
        return "Auto{" +
                "marka='" + marka + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}
