package com.boring.demo.service;

import com.boring.demo.model.Menu;
import com.boring.demo.repo.MenuRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@Service
public class MenuService {

    @Resource
    private MenuRepository menuRepository;

    public Flux<Menu> findAll() {
        return menuRepository.findAll();
    }
}
