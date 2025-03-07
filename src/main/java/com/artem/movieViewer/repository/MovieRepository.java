package com.artem.movieViewer.repository;

import com.artem.movieViewer.Director;
import com.artem.movieViewer.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByGenre(String genre);
}
