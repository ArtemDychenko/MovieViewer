package com.artem.movieViewer.util;

import com.artem.movieViewer.director.entity.Director;
import com.artem.movieViewer.movie.entity.Movie;
import com.artem.movieViewer.director.repository.api.DirectorRepository;
import com.artem.movieViewer.movie.repository.api.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DataInitializer {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    @Bean
    @Primary
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(8086);
        return tomcat;
    }

    @Autowired
    public DataInitializer(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostConstruct
    public void init() {
        if (directorRepository.count() > 0) {
            return;
        }

        var directors = List.of(
                Director.builder()
                        .name("Christopher Nolan")
                        .yearOfBirth(1970)
                        .build(),

                Director.builder()
                        .name("Yorgos Lanthimos")
                        .yearOfBirth(1973)
                        .build(),

                Director.builder()
                        .name("Paolo Sorrentino")
                        .yearOfBirth(1970)
                        .build(),

                Director.builder()
                        .name("Quentin Tarantino")
                        .yearOfBirth(1963)
                        .build()
        );


        directorRepository.saveAll(directors);

        var movies = List.of(
                Movie.builder()
                        .name("Inception")
                        .date_of_release(2010)
                        .time(148)
                        .genre("Science Fiction")
                        .director(directors.get(0))
                        .build(),

                Movie.builder()
                        .name("Pulp Fiction")
                        .date_of_release(1994)
                        .time(149)
                        .genre("Crime Thriller")
                        .director(directors.get(3))
                        .build(),


                Movie.builder()
                        .name("Kill Bill")
                        .date_of_release(2004)
                        .time(111)
                        .genre("Action Thriller")
                        .director(directors.get(3))
                        .build(),


                Movie.builder()
                        .name("The Hand of God")
                        .date_of_release(2021)
                        .time(130)
                        .genre("Comedy Drama")
                        .director(directors.get(2))
                        .build()
        );

        movieRepository.saveAll(movies);
    }
}
