package com.artem.movieViewer.security;

import com.artem.movieViewer.user.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtRequestFilter jwtRequestFilter;
    private final AccessDeniedHandler accessDeniedHandler;


    @Autowired
    public SecurityConfig(
            JwtRequestFilter jwtRequestFilter,
            AccessDeniedHandler accessDeniedHandler
    ) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, DefaultAuthenticationEntryPoint authenticationEntryPoint) throws Exception {

        http.securityMatcher("/api/**").authorizeHttpRequests(rmr -> rmr
                                .requestMatchers(
                                        HttpMethod.GET,
                                        "/api/users"
                                ).hasRole(UserRole.ADMIN.getValue())
                                .requestMatchers(
                                        HttpMethod.DELETE,
                                        "/api/movie/{id}",
                                        "/api/director/{id}"
//                                "/api/comment/{id}" TODO warto dodać kiedy zaimplementuję message
                                ).hasRole(UserRole.ADMIN.getValue())
                                .requestMatchers(
                                        HttpMethod.PUT,
                                        "/api/movie/{id}",
                                        "/api/director/{id}"
                                ).hasRole(UserRole.ADMIN.getValue())
                                .requestMatchers(
                                        HttpMethod.POST,
                                        "/api/movie",
                                        "/api/director"
                                ).hasRole(UserRole.ADMIN.getValue())
                                .requestMatchers(
//                                "/api/comment/*", TODO dodać kiedy zaimplementuję comment
                                        "/api/profile",
                                        "/api/profile/*",
                                        "/api/logout"
                                ).authenticated()
                                .anyRequest().permitAll()
                ).httpBasic(httpbc -> httpbc
                        .authenticationEntryPoint(authenticationEntryPoint)
                ).sessionManagement(smc -> smc
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(ehc -> ehc
                        .accessDeniedHandler(accessDeniedHandler)
                );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}