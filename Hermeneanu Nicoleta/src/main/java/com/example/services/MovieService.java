package com.example.services;

import com.example.classes.Movie;
import com.example.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @PersistenceContext
    private EntityManager e;

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listAll(){
        List<Movie> movies = new ArrayList();
        movieRepository.findAll().forEach((movies::add));
        return movies;
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie findByName(Movie movie) {
        return movieRepository.findMovieByName(movie.getName());
    }

    public List<Movie> listAllWatchedMovies(){
        List<Movie> movies = new ArrayList();
        movieRepository.findAllWatchedMovies().forEach((movies::add));
        return movies;
    }

    public List<Movie> listAllFavoriteMovies(){
        List<Movie> movies = new ArrayList();
        movieRepository.findAllFavoriteMovies().forEach((movies::add));
        return movies;
    }


    @Transactional
    public void save(Movie movie) {
        e.persist(movie);
    }

    public void delete(Movie movie) {
        movieRepository.delete((movie));
    }
}
