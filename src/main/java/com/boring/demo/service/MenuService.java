package com.boring.demo.service;

import com.boring.demo.model.Menu;
import com.boring.demo.repo.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Flux<Menu> findAll() {
        return menuRepository.findAll();
    }
}
