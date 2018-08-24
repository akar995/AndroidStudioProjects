package com.example.oliver.intenttest;

public class Character {
    private int speed ;
    private int heath;
    private String speciality;

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {

        return speciality;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getHeath() {

        return heath;
    }

    public void setSpeed(int speed) {

        this.speed = speed;
    }

    public int getSpeed() {

        return speed;
    }


    void defineStrength(int speed,int health){
        this.setSpeed(speed);
        this.setHeath(health);
    }
    void defineStrength(int speed,int health,String speciality){
        defineStrength(speed,health);
        setSpeciality(speciality);
    }

}
