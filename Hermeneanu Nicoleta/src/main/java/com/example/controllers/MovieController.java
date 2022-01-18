package com.example.controllers;

import com.example.classes.Movie;
import com.example.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        Collection<Movie> movies = movieService.listAll();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/home/watched{id}")
    public String addWatchList(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        Collection<Movie> movies = movieService.listAll();
        movie.get().setWatched(true);
        movieService.save(movie.get());
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/add_movie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "add_movie";
    }

    @PostMapping("/add_movie/save")
    public String saveMovie(Movie movie, RedirectAttributes redirectAttributes) {
        movieService.save(movie);
        redirectAttributes.addFlashAttribute("message", "Movie added succesfully");
        return "redirect:/home";
    }

    @GetMapping("/find")
    public String find(Model model) {
        model.addAttribute("movie", new Movie());
        return "find_movie";
    }

    @PostMapping("/find_name")
    public String findMovie(Movie movie, Model model) {
        model.getAttribute("movie");
        model.addAttribute("movie", movieService.findByName(movie));
        Movie find = movieService.findByName(movie);
        return "update_movie";
    }

    @PostMapping("/update_movie/save")
    public String updateMovieSave(@ModelAttribute("movie") final Movie movie, RedirectAttributes redirectAttributes) {
        Optional<Movie> m = movieService.findById(movie.getId());
        m.get().setName(movie.getName());
        m.get().setGenre(movie.getGenre());
        m.get().setDuration(movie.getDuration());
        m.get().setRating(movie.getRating());
        m.get().setDescription(movie.getDescription());
        m.get().setYearOfApparition(movie.getYearOfApparition());
        m.get().setWatched(movie.getWatched());
        m.get().setFavorite(movie.getFavorite());
        movieService.save(m.get());
        redirectAttributes.addFlashAttribute("message", "Movie update succesfully");
        return "redirect:/home";
    }

    @GetMapping("/delete_movie")
    public String findToDelete(Model model) {
        model.addAttribute("movie", new Movie());
        return "delete_movie";
    }

    @PostMapping("/delete_movie/save")
    public String deleteMovieSave(@ModelAttribute("movie") final Movie movie, RedirectAttributes redirectAttributes) {
        Movie m = movieService.findByName(movie);
        movieService.delete(m);
        redirectAttributes.addFlashAttribute("message", "Movie update succesfully");
        return "redirect:/home";
    }

    @GetMapping("/watch_list")
    public String watchList(Model model) {
        Collection<Movie> watched_movies = movieService.listAllWatchedMovies();
        model.addAttribute("watched_movies", watched_movies);
        return "watch_list";
    }

    @GetMapping("/watch_list/unwatch{id}")
    public String unwatchMovie(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        Collection<Movie> watched_movies = movieService.listAllWatchedMovies();
        movie.get().setWatched(false);
        movieService.save(movie.get());
        model.addAttribute("watched_movies", watched_movies);
        return "redirect:/watch_list";
    }

    @GetMapping("/watch_list/favorite{id}")
    public String favoriteMovie(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        Collection<Movie> watched_movies = movieService.listAllWatchedMovies();
        movie.get().setFavorite(true);
        movieService.save(movie.get());
        model.addAttribute("watched_movies", watched_movies);
        return "redirect:/watch_list";
    }

    @GetMapping("/favorite_movies")
    public String favoriteMovies(Model model) {
        Collection<Movie> favorite_movies = movieService.listAllFavoriteMovies();
        model.addAttribute("favorite_movies", favorite_movies);
        return "favorite_movies";
    }

    @GetMapping("/favorite_movies/delete{id}")
    public String deleteFavoriteMovie(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        Collection<Movie> favorite_movies = movieService.listAllFavoriteMovies();
        movie.get().setFavorite(false);
        movieService.save(movie.get());
        model.addAttribute("favorite_movies", favorite_movies);
        return "redirect:/favorite_movies";
    }
}
