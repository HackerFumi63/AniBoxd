package com.example.demo;
public class Anime {
    // your fields here
    private double rating;
    private String title;
    private String genre;
    private String status;
    private int watchedEpisodes;
    private int totalEpisodes;
    // your constructor here
    public Anime(String title, String genre, String status, int watchedEpisodes, int totalEpisodes, double rating) {
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.watchedEpisodes = watchedEpisodes;
        this.totalEpisodes = totalEpisodes;
        this.rating = rating;
    }
    // Setting and getting methods for all my fields
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
        
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getWatchedEpisodes() {
        return watchedEpisodes;
    }
    public void setWatchedEpisodes(int watchedEpisodes) {
        this.watchedEpisodes = watchedEpisodes;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }
    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getProgressPercentage() {
        if (watchedEpisodes == 0) {
            return 0.0;
        }
        return (double) watchedEpisodes / totalEpisodes * 100;
    }
    
}
    
    