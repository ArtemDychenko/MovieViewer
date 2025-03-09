package com.artem.movieViewer.movie.function;

import com.artem.movieViewer.director.service.api.DirectorService;

public class RequestToMovieFunction {

    private final DirectorService directorService;

    public RequestToMovieFunction(DirectorService directorService) {
        this.directorService = directorService;
    }

//    @Override
//    public Movie apply(PostMovieRequest postMovieRequest) {
//        return Movie.builder()
//                .director(directorService.findById(postMovieRequest.getDirectorId()))
//                .build();
//    }
}
