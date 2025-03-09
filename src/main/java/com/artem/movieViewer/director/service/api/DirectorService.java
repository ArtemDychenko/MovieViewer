package com.artem.movieViewer.director.service.api;


import com.artem.movieViewer.director.entity.Director;

import java.util.List;
import java.util.Optional;


public interface DirectorService {
    Optional<Director> findById(int id);

    void create(Director director);

    List<Director> findAll();

    void delete(int id);


}
