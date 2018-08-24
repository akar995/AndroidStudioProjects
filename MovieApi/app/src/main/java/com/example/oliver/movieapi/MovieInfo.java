package com.example.oliver.movieapi;

public class MovieInfo {
    private String Name;
    private String ImageSrc;
    private int id;

    public String getName() {
        return Name;
    }

    public String getImageSrc() {
        return ImageSrc;
    }

    public int getId() {
        return id;
    }

    public MovieInfo(String name, String imageSrc, int id) {
        Name = name;
        ImageSrc = imageSrc;
        this.id = id;
    }
}
