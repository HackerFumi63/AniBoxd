package com.example.demo;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


    // This class needs @Controller so Spring registers it and 
    // watches for incoming web requests
    // We need some way to store the anime objects while the app runs.
    // No database yet, so: a List<Anime> that lives in memory.
    // This list needs to exist for the whole life of the controller,
    // not be recreated every time someone visits a page.
    // We probably also want some way to generate a unique id for each
    // new anime we add (even though we're holding off on the id field
    // in Anime itself for now — keep this in mind for later).

    @Controller
    public class AnimeController {
    private final ArrayList<Anime> animes = new ArrayList<>();

    // METHOD 1: Show the homepage
    // - Needs @GetMapping("/") so Spring knows: when someone visits
    //   the root URL, run this method
    // - Needs a way to hand the list of anime to the HTML template
    //   (recall: Thymeleaf's ${animes} has to come from somewhere —
    //   that "somewhere" is this method)
    // - Needs to return the name of the template to render (your
    //   file is templates/index.html, so what string does that map to?)
    @GetMapping("/")
        public String showHomePage(Model model) {
        model.addAttribute("animes",animes);
        return "index";
        }

    // METHOD 2: Handle the "add new anime" form submission
    // - Needs @PostMapping("/add") (or whatever your form's
    //   action="..." attribute says) so Spring knows: when the form
    //   submits, run this method
    // - Needs to receive the submitted form data as an actual Anime
    //   object (this is where @ModelAttribute comes in — it auto-fills
    //   an Anime using your form's field names, matched against
    //   Anime's setters)
    // - Needs to add that new Anime into the in-memory list
    // - Needs to send the browser back to the homepage afterward
    //   (redirect, not just returning "index" again — why? think
    //   about what happens if the user hits refresh after submitting
    //   a form)
    @PostMapping("/add")
    public String addAnime(@ModelAttribute Anime anime) {
        animes.add(anime);
        return "redirect:/";
    }
}