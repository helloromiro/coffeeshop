package com.example.coffeeshop.service;

import com.example.coffeeshop.dto.CoffeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CoffeeService {
    CoffeeDTO createCoffee(CoffeeDTO coffeeDTO);
    CoffeeDTO getCoffeeById(Long coffeeId);
    Page<CoffeeDTO> getAllCoffees(Pageable pageable);
}
