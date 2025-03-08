package com.artem.movieViewer.director.service.impl;


import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.director.repository.api.DirectorRepository;
import com.artem.movieViewer.director.service.api.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DirectorDefaultService implements DirectorService {
    private final DirectorRepository directorRepository;
    private final String directorServiceUrl = "http://localhost:8082/api/directors";

    @Autowired
    public DirectorDefaultService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }


    @Override
    public Optional<Director> getDirectorById(UUID id) {
        return directorRepository.findById(id);
    }


    @Override
    public void createDirector(Director director) {
        directorRepository.save(director);
    }


    @Override
    public void deleteDirector(UUID id) {
        directorRepository.deleteById(id);
    }

    public List<Director> findByName(String name) {
        List<Director> directors = directorRepository.findByName(name);
        if (directors.isEmpty()) {
            throw new IllegalArgumentException("No directors found with name '" + name + "'");
        }
        return directors;
    }




}
