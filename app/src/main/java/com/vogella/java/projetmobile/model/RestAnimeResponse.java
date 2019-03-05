package com.vogella.java.projetmobile.model;

import java.util.List;

public class RestAnimeResponse {

    private int count = 50;
    private List<Anime> top;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Anime> getResults() {
        return top;
    }

    public void setResults(List<Anime> results) {
        this.top = results;
    }
}
