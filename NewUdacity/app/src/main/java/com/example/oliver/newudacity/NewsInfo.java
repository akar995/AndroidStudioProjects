package com.example.oliver.newudacity;

public class NewsInfo {
    private String titleNew;
    private String imageSrc;
    private String author;
    private String section;
    private String webUrl;

    public NewsInfo(String titleNew, String imageSrc, String author, String section, String webUrl) {
        this.titleNew = titleNew;
        this.imageSrc = imageSrc;
        this.author = author;
        this.section = section;
        this.webUrl = webUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getTitleNew() {
        return titleNew;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getAuthor() {
        return author;
    }

    public String getSection() {
        return section;
    }
}