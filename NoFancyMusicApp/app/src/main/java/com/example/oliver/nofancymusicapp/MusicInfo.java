package com.example.oliver.nofancymusicapp;
public class MusicInfo {
    private String mTrackName;
    private String mArtisticName;
    private int mIconImage;
    public String getmTrackName() {
        return mTrackName;
    }
    public String getmArtisticName() {
        return mArtisticName;
    }
    public int getmIconImage() {
        return mIconImage;
    }
    public MusicInfo(String trackName, String artisticName, int iconImage) {
        mTrackName = trackName;
        mArtisticName = artisticName;
        mIconImage = iconImage;
    }

}
