package com.example.netfluxexample;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ReactiveStreamsTests {
    Flux<String> movies = Flux.just("Movie1", "Movie2", "Movie3", "Movie4", "Movie5");

    @Test
    public void doOnEachTest() {
        movies.doOnEach(m -> log.info("{}", m)).subscribe();
    }

    @Test
    public void subscriberConsumerTest() {
        movies.subscribe(m -> log.info("Element {}", m), null, () -> {
            log.info("Done!");
        });
    }

    @Test
    public void subscriberConsumerWithObjectsTest() {
        Consumer<String> logConsumer = e -> log.info("Element {}", e);
        Runnable done = () -> log.info("Done");
        movies.subscribe(logConsumer, null, done);
    }
}
