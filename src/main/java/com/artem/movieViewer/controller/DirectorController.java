package com.artem.movieViewer.controller;

import com.artem.movieViewer.Director;
import com.artem.movieViewer.DirectorDTO;
import com.artem.movieViewer.MovieDTO;
import com.artem.movieViewer.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAllDirectors().stream()
                .map(DirectorDTO::new)
                .collect(Collectors.toList());
    }
}
