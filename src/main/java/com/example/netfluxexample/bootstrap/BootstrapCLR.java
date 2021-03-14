package com.example.netfluxexample.bootstrap;

import com.example.netfluxexample.domain.Movie;
import com.example.netfluxexample.repository.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;
    
    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
            Flux.just("Movie1", "Movie2", "Movie3", "Movie4", "Movie5")
            .map(title -> new Movie(title))
            .flatMap(movieRepository::save)
        ).subscribe(null, null, () -> {
            movieRepository.findAll().subscribe(System.out::println);
        });
    }
    
}
