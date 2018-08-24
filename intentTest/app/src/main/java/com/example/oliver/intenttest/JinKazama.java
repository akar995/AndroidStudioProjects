package com.example.oliver.intenttest;

public class JinKazama extends Character{

    @Override
    void defineStrength(int speed, int health) {
        this.setSpeed(speed*2);
        this.setHeath((int)(health*0.5));
    }

    @Override
    void defineStrength(int speed, int health, String speciality) {
        defineStrength(20,1000);
        speciality="invisibilty for 3 seconds";
        this.setSpeciality(speciality);
    }
}
