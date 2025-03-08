package com.artem.movieViewer.movie.controller.api;

import com.artem.movieViewer.movie.dto.GetDirectorResponse;
import com.artem.movieViewer.movie.dto.GetDirectorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface DirectorController {

    @GetMapping("api/directors")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDirectorsResponse getDirectors();


    @GetMapping("/api/directors/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDirectorResponse getDirector(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/directors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDirector(
            @PathVariable("id")
            UUID id
    );

}
