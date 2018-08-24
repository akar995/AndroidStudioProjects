package com.example.avraz.tourguideapp;

public class Places {
    int image;
    String title;
    String paragraph;
    String address;

    public Places(int image, String title, String paragraph, String address) {

        this.image = image;
        this.title = title;
        this.paragraph = paragraph;
        this.address = address;
    }

    public int getImage() {
        return image;
    }


    public String getTitle() {
        return title;
    }


    public String getParagraph() {
        return paragraph;
    }


    public String getAddress() {
        return address;
    }


    //PUT STRINGS

}
