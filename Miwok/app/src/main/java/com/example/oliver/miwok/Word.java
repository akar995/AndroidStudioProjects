package com.example.oliver.miwok;

public class Word {

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    private String  mDefaultTranslation;

    private String mMiwokTranslation;
    public Word(String DefaultTranslation, String MiwokTranslation){
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTranslation;
    }

}

