package com.artem.movieViewer.config;

import com.artem.movieViewer.Movie;
import com.artem.movieViewer.Director;
import com.artem.movieViewer.service.DirectorService;
import com.artem.movieViewer.service.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AuiLabsApplicationConfig {

    @Bean
    public CommandLineRunner demo(MovieService movieService, DirectorService directorService) {
        return (args) -> {

        };
    }

    @Bean
    @Primary
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(8081);
        return tomcat;
    }
}
