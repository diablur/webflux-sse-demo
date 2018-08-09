package com.boring.demo.handler;

import com.boring.demo.model.Menu;
import com.boring.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class MenuHandler {

    private final MenuService menuService;

    @Autowired
    public MenuHandler(MenuService menuService) {
        this.menuService = menuService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Mono<ServerResponse> getMenu(ServerRequest request) {
        Flux<Menu> menu = menuService.findAll();
        return ok().contentType(APPLICATION_JSON_UTF8).body(menu, Menu.class);
    }
}
