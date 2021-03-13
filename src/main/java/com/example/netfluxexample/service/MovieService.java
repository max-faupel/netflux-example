package com.example.netfluxexample.service;

import com.example.netfluxexample.domain.Movie;
import com.example.netfluxexample.domain.MovieEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Flux<MovieEvent> events(String movieId);
    Mono<Movie> getMovieById(String id);
    Flux<Movie> getAllMovies();
}
