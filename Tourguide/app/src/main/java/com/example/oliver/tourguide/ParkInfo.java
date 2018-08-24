package com.example.oliver.tourguide;

public class ParkInfo {
    String mTitle;
    String mLocation;
    int mImageSrc;

    public ParkInfo(String mTitle, String mLocation, int mImageSrc) {
        this.mTitle = mTitle;
        this.mLocation = mLocation;
        this.mImageSrc = mImageSrc;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmLocation() {
        return mLocation;
    }

    public int getmImageSrc() {
        return mImageSrc;
    }
}
