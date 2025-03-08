package com.artem.movieViewer.movie.service.api;



import com.artem.movieViewer.movie.entity.Director;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface DirectorService {
    Optional<Director> getDirectorById(UUID id);

    void createDirector(Director director);

    List<Director> getAllDirectors();

    void deleteDirector(UUID id);


}
