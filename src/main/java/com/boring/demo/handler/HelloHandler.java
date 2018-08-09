package com.boring.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class HelloHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just("Hello World!"), String.class);
    }

    public Mono<ServerResponse> sendTimePerSec(ServerRequest request) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1)).
                        map(l -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))),
                String.class);
    }
}
