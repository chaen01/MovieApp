package com.example.movieapp;

public class Movie {
    private String title;
    private int year;
    private String imdbID;
    private String type;
    private String posterUrl;

    public Movie(String title, int year, String imdbID, String type, String posterUrl) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.posterUrl = posterUrl;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

}
