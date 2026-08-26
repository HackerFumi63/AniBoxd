package com.example.demo;

public class Anime {
    private String title;
    private String genre;
    private String status;
    private int watchedEpisodes;
    private int totalEpisodes;
    private String rating;
    private int progressPercentage;

    public Anime(String title, String genre, String status, int watchedEpisodes, int totalEpisodes, String rating) {
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.watchedEpisodes = watchedEpisodes;
        this.totalEpisodes = totalEpisodes;
        this.rating = rating;
        // Simple calculation for the progress bar fill
        this.progressPercentage = (totalEpisodes > 0) ? (watchedEpisodes * 100 / totalEpisodes) : 0;
    }

    // Getters so Thymeleaf can read them
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getStatus() { return status; }
    public int getWatchedEpisodes() { return watchedEpisodes; }
    public int getTotalEpisodes() { return totalEpisodes; }
    public String getRating() { return rating; }
    public int getProgressPercentage() { return progressPercentage; }
}

