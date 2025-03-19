package com.example.coffeeshop.repository;

import com.example.coffeeshop.model.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CoffeeRepository {

    Coffee save(Coffee coffee);
    Optional<Coffee> findById(Long id);
    Page<Coffee> findAll(Pageable pageable);
}

