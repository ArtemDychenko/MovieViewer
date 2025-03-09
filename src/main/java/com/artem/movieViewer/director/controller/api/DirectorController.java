package com.artem.movieViewer.director.controller.api;

import com.artem.movieViewer.director.dto.GetDirectorResponse;
import com.artem.movieViewer.director.dto.GetDirectorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface DirectorController {

    @GetMapping("api/director")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDirectorsResponse getDirectors();


    @GetMapping("/api/director/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDirectorResponse getDirector(
            @PathVariable("id")
            int id
    );

    @DeleteMapping("/api/director/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDirector(
            @PathVariable("id")
            int id
    );

}
