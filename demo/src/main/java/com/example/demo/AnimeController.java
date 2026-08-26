package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimeController {

    // A dynamic, resizable list that holds data while the server is running
    private static final List<Anime> myAnimes = new ArrayList<>();

    // This block runs once when the app starts to pre-fill your list
    static {
        myAnimes.add(new Anime("Frieren: Beyond Journey's End", "Fantasy • Adventure", "completed", 28, 28, "★ 10 / 10"));
        myAnimes.add(new Anime("Naruto", "Action • Shonen", "watching", 135, 220, "★ 9 / 10"));
        myAnimes.add(new Anime("Steins;Gate", "Sci-Fi • Thriller", "planning", 0, 24, "Not Rated"));
    }

    @GetMapping("/")
    public String showLibrary(Model model) {
        model.addAttribute("animes", myAnimes);
        
        // Calculate your dashboard statistics on the fly
        long totalAnime = myAnimes.size();
        
        long completedCount = myAnimes.stream()
            .filter(a -> "completed".equalsIgnoreCase(a.getStatus()))
            .count();
            
        long watchingCount = myAnimes.stream()
            .filter(a -> "watching".equalsIgnoreCase(a.getStatus()))
            .count();
            
        long totalEpisodesWatched = myAnimes.stream()
            .mapToLong(Anime::getWatchedEpisodes)
            .sum();

        // Send stats down to the HTML placeholder hooks
        model.addAttribute("totalAnime", totalAnime);
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("watchingCount", watchingCount);
        model.addAttribute("totalEpisodes", totalEpisodesWatched);
        
        return "index";
    }

    // This new route catches the inputs from your HTML "+ Add Anime" modal form submission
    @PostMapping("/add")
    public String addAnime(
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam String status,
            @RequestParam int watchedEpisodes,
            @RequestParam int totalEpisodes,
            @RequestParam String rating) {
        
        // Create a new instance and inject it into your array list
        myAnimes.add(new Anime(title, genre, status, watchedEpisodes, totalEpisodes, rating));
        
        // Refresh the page back to index to show everything updated instantly
        return "redirect:/";
    }
}
