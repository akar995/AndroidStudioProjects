package com.example.oliver.newudacity;

import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Root {
    List<result> results=new ArrayList<>();
    public int pagees;

    public int getPagees() {
        return pagees;
    }

    public List<result> getResults() {
        return results;
    }

    public void setResults(List<result> results) {
        this.results = results;
    }

    public void setPagees(int pagees) {
        this.pagees = pagees;
    }
}
