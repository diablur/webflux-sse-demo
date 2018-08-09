package com.boring.demo.repo;

import com.boring.demo.model.Menu;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends ReactiveMongoRepository<Menu, Integer> {

}
