package com.boring.demo.repo;

import com.boring.demo.model.Menu;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MenuRepository extends ReactiveMongoRepository<Menu, Integer> {

}
