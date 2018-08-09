package com.boring.demo.config;

import com.boring.demo.handler.HelloHandler;
import com.boring.demo.handler.MenuHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfig {

    private final HelloHandler helloHandler;

    private final MenuHandler menuHandler;

    @Autowired
    public RoutingConfig(HelloHandler helloHandler, MenuHandler menuHandler) {
        this.helloHandler = helloHandler;
        this.menuHandler = menuHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> helloFunction() {
        return route(GET("/hello").and(accept(APPLICATION_JSON)), helloHandler::hello)
                .andRoute(GET("/time"), helloHandler::sendTimePerSec);
    }

    @Bean
    public RouterFunction<ServerResponse> menuFunction() {
        return route(GET("/list").and(accept(APPLICATION_JSON)), menuHandler::getMenu);
    }
}
