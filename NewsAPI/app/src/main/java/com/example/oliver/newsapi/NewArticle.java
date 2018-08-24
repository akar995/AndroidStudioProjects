package com.example.oliver.newsapi;

public class NewArticle {
    private String mtitle;
    private String mauthor;
    private String mimageSrc;
    private String mDes;

    public String getmDes() {
        return mDes;
    }

    public String getMtitle() {
        return mtitle;
    }

    public String getMauthor() {
        return mauthor;
    }

    public String getMimageSrc() {
        return mimageSrc;
    }

    public NewArticle(String mtitle, String mauthor, String mimageSrc,String mDes) {
        this.mtitle = mtitle;
        this.mauthor = mauthor;
        this.mimageSrc = mimageSrc;
        this.mDes=mDes;
    }
}
