package com.example.oliver.onlineimagereader;

public class NewArticle {
    private String mtitle;
    private String mauthor;
    private String mimageSrc;

    public String getMtitle() {
        return mtitle;
    }

    public String getMauthor() {
        return mauthor;
    }

    public String getMimageSrc() {
        return mimageSrc;
    }

    public NewArticle(String mtitle, String mauthor, String mimageSrc) {
        this.mtitle = mtitle;
        this.mauthor = mauthor;
        this.mimageSrc = mimageSrc;
    }
}
