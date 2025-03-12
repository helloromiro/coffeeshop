package com.example.coffeeshop.service;

import com.example.coffeeshop.dto.CoffeeDTO;


public interface CoffeeService {
    CoffeeDTO createCoffee(CoffeeDTO coffeeDTO);
    CoffeeDTO getCoffeeById(Long coffeeId);
}
