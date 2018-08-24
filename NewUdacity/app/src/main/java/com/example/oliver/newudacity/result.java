package com.example.oliver.newudacity;

public class result {

    public String sectionName;
    public String webUrl;
    public String webTitle;

    public String getWebTitle() {
        return webTitle;
    }

    Fields fields = new Fields();

    public String getSectionName() {
        return sectionName;
    }

    public String getWebUrl() {
        return webUrl;
    }

    class Fields {
        public String byline;
        public String thumbnail;

        public String getByline() {
            return byline;
        }

        public String getThumbnail() {
            return thumbnail;
        }

    }
}
