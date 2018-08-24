package com.example.oliver.tourguide;

public class RestaurantInfo {
    String mTitle;
    String mPhoneNumber;
    String mLocation;

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

    int mImageSrc;

    public RestaurantInfo(String title, String phoneNumber, String location, int imageSrc) {
        mTitle = title;
        mPhoneNumber = phoneNumber;
        mLocation = location;
        mImageSrc = imageSrc;
    }
}
