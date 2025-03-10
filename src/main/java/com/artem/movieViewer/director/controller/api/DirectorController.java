package com.artem.movieViewer.director.controller.api;

import com.artem.movieViewer.director.dto.GetDirectorResponse;
import com.artem.movieViewer.director.dto.GetDirectorsResponse;
import com.artem.movieViewer.director.dto.PostDirectorRequest;
import com.artem.movieViewer.director.dto.PutDirectorRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("api/director")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    Map<String, Integer> postDirector(@RequestBody @Valid PostDirectorRequest request);

    @PutMapping("/api/director/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    Map<String, Integer> putDirector(@PathVariable int id, @RequestBody @Valid PutDirectorRequest request);

    @DeleteMapping("/api/director/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDirector(
            @PathVariable("id")
            int id
    );

}
