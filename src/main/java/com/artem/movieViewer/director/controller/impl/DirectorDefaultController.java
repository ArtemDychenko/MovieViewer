package com.artem.movieViewer.director.controller.impl;

import com.artem.movieViewer.director.controller.api.DirectorController;
import com.artem.movieViewer.director.dto.GetDirectorResponse;
import com.artem.movieViewer.director.dto.GetDirectorsResponse;
import com.artem.movieViewer.director.function.DirectorToResponseFunction;
import com.artem.movieViewer.director.function.DirectorsToResponseFunction;
import com.artem.movieViewer.director.service.impl.DirectorDefaultService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log
public class DirectorDefaultController implements DirectorController {
    private final DirectorDefaultService directorService;

    private final DirectorToResponseFunction directorToResponse;

    private final DirectorsToResponseFunction directorsToResponse;

    @Autowired
    public DirectorDefaultController(DirectorDefaultService directorService, DirectorToResponseFunction directorToResponse, DirectorsToResponseFunction directorsToResponse) {
        this.directorService = directorService;
        this.directorToResponse = directorToResponse;
        this.directorsToResponse = directorsToResponse;
    }


    @Override
    public GetDirectorsResponse getDirectors() {
        return directorsToResponse.apply(directorService.findAll());
    }


    @Override
    public GetDirectorResponse getDirector(int id) {
        return directorService.findById(id)
                .map(directorToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @Override
    public void deleteDirector(@PathVariable int id) {
        directorService.findById(id)
                .ifPresentOrElse(
                        director -> directorService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );

    }
}


