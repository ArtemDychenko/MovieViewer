package com.artem.movieViewer.director.service.impl;


import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.director.repository.api.DirectorRepository;
import com.artem.movieViewer.director.service.api.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorDefaultService implements DirectorService {
    private final DirectorRepository directorRepository;
    private final String directorServiceUrl = "http://localhost:8082/api/directors";

    @Autowired
    public DirectorDefaultService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }


    @Override
    public Optional<Director> findById(int id) {
        return directorRepository.findById(id);
    }


    @Override
    public void create(Director director) {
        directorRepository.save(director);
    }


    @Override
    public void delete(int id) {
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
