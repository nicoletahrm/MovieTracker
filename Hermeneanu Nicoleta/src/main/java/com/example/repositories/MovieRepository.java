package com.example.repositories;

import com.example.classes.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Query("SELECT '*' FROM Movie")
    Collection<Movie> findAllMovies();

    @Query("SELECT m FROM Movie m WHERE m.name=?1")
    Movie findMovieByName(String name);

    @Query("SELECT m FROM Movie m WHERE m.watched=true ORDER BY m.name")
    Collection<Movie> findAllWatchedMovies();

    @Query("SELECT m FROM Movie m WHERE m.favorite=true ORDER BY m.name")
    Collection<Movie> findAllFavoriteMovies();
}
