package com.example.netfluxexample.repository;

import com.example.netfluxexample.domain.Movie;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
    
}
