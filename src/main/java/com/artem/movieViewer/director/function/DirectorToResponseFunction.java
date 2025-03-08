package com.artem.movieViewer.director.function;


import com.artem.movieViewer.director.dto.GetDirectorResponse;
import com.artem.movieViewer.director.entity.Director;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class DirectorToResponseFunction implements Function<Director, GetDirectorResponse> {

    @Override
    public GetDirectorResponse apply(Director entity) {
        return GetDirectorResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .yearOfBirth(entity.getYearOfBirth())
//                .movie(GetDirectorResponse.Movie.builder()
//                        .id(entity.getMovies())
//                        .name(entity.getName())
//                        .date_of_release(entity.getYearOfBirth())
//                        .genre(entity.get)
//                        .build())
                .build();
    }

}
