package com.artem.movieViewer.movie.function;


import com.artem.movieViewer.movie.dto.GetDirectorsResponse;
import com.artem.movieViewer.movie.entity.Director;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


@Component
public class DirectorsToResponseFunction implements Function<List<Director>, GetDirectorsResponse> {

    @Override
    public GetDirectorsResponse apply(List<Director> entities) {
        return GetDirectorsResponse.builder()
                .directors(entities.stream()
                        .map(director -> GetDirectorsResponse.Director.builder()
                                .id(director.getId())
                                .name(director.getName())
                                .yearOfBirth(Integer.toString(director.getYearOfBirth()))
                                .build())
                        .toList())
                .build();
    }

}
