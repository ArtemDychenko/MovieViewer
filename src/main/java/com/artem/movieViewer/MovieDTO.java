package com.artem.movieViewer;

import lombok.Data;

import java.util.Objects;

@Data
public class MovieDTO implements Comparable<MovieDTO> {
    private final String name;
    private final int date_of_release;
    private final int time;
    private final String genre;
    private final String director;


    public MovieDTO(Movie movie) {
        this.name = movie.getName();
        this.date_of_release = movie.getDate_of_release();
        this.time = movie.getTime();
        this.genre = movie.getGenre();
        this.director = movie.getDirector() != null ? movie.getDirector().getName() : "No director";
    }

    @Override
    public int compareTo(MovieDTO other) {
        return this.name.compareTo(other.name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO that = (MovieDTO) o;
        return Integer.compare(that.date_of_release, date_of_release) == 0 && Objects.equals(name, that.name) && Integer.compare(that.time, time) == 0 && Objects.equals(genre, that.genre) && Objects.equals(director, that.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date_of_release);
    }
}