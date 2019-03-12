package com.vogella.java.projetmobile.model;

public class Anime {
    private int rank;
    private String title;
    private String url;
    private String image_url;
    private int members;
    private double score;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public double getScore() {
        return score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
