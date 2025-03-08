package com.artem.movieViewer.movie.repository.api;

import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByGenre(String genre);
    Optional<Movie> findByName(String name);
    List<Movie> findAllByDirector(Director director);
}
