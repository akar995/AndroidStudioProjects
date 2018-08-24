package com.example.oliver.tourguide;

public class HotelInfo {
    private String mTitle;
    private String mPhoneNumber;
    private String mLocation;
    int mImageSrc;

    public String getmTitle() {
        return mTitle;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public String getmLocation() {
        return mLocation;
    }

    public int getmImageSrc() {
        return mImageSrc;
    }

    public HotelInfo(String mTitle, String mPhoneNumber, String mLocation, int mImageSrc) {
        this.mTitle = mTitle;
        this.mPhoneNumber = mPhoneNumber;
        this.mLocation = mLocation;
        this.mImageSrc = mImageSrc;
    }
}
