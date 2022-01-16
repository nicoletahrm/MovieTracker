package com.example.classes;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movie_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "duration")
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "genre")
    private Genre genre;

    @Column(nullable = false, name = "year_of_apparition")
    private int year_of_apparition;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "rating")
    private float rating;

    @Column(nullable = false, name = "watched", columnDefinition = "boolean default false")
    private Boolean watched;

    @Column(nullable = false, name = "favorite", columnDefinition = "boolean default false")
    private Boolean favorite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Movie(Long movie_id, String name, int duration, Genre genre, int year_of_apparition, String description, float rating, User user) {
        this.movie_id = movie_id;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.year_of_apparition = year_of_apparition;
        this.description = description;
        this.rating = rating;
        this.user = user;
    }

    public Movie() {
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Long getId() {
        return movie_id;
    }

    public void setId(Long id) {
        this.movie_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYearOfApparition() {
        return year_of_apparition;
    }

    public void setYearOfApparition(int year_of_apparition) {
        this.year_of_apparition = year_of_apparition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movie_id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", genre=" + genre +
                ", year_of_apparition=" + year_of_apparition +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
