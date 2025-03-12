package com.example.coffeeshop.service;

import com.example.coffeeshop.dto.CoffeeDTO;
import com.example.coffeeshop.exception.ResourceNotFoundException;
import com.example.coffeeshop.mapper.CoffeeMapper;
import com.example.coffeeshop.model.Coffee;
import com.example.coffeeshop.repository.CoffeeJpaRepository;
import org.springframework.stereotype.Service;


@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeJpaRepository coffeeJpaRepository;

    public CoffeeServiceImpl(CoffeeJpaRepository coffeeJpaRepository) {
        this.coffeeJpaRepository = coffeeJpaRepository;
    }


    @Override
    public CoffeeDTO createCoffee(CoffeeDTO coffeeDTO) {
        Coffee coffee = CoffeeMapper.toCoffee(coffeeDTO);
        Coffee savedCoffee = coffeeJpaRepository.save(coffee);
        return CoffeeMapper.toCoffeeDTO(savedCoffee);
    }

    @Override
    public CoffeeDTO getCoffeeById(Long coffeeId) {
        Coffee coffee = coffeeJpaRepository.findById(coffeeId).orElseThrow(()->
                new ResourceNotFoundException("Coffee " + coffeeId + " not found"));
        return CoffeeMapper.toCoffeeDTO(coffee);
    }

}
