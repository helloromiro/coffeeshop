package com.example.coffeeshop.service;

import com.example.coffeeshop.dto.CoffeeDTO;
import com.example.coffeeshop.exception.ResourceNotFoundException;
import com.example.coffeeshop.mapper.CoffeeMapper;
import com.example.coffeeshop.model.Coffee;
import com.example.coffeeshop.repository.CoffeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }


    @Override
    public CoffeeDTO createCoffee(CoffeeDTO coffeeDTO) {
        Coffee coffee = CoffeeMapper.toCoffee(coffeeDTO);
        Coffee savedCoffee = coffeeRepository.save(coffee);
        return CoffeeMapper.toCoffeeDTO(savedCoffee);
    }

    @Override
    public CoffeeDTO getCoffeeById(Long coffeeId) {
        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Coffee " + coffeeId + " not found"));
        return CoffeeMapper.toCoffeeDTO(coffee);
    }

    @Override
    public Page<CoffeeDTO> getAllCoffees(Pageable pageable) {
        return coffeeRepository.findAll(pageable)
                .map(CoffeeMapper::toCoffeeDTO);
    }
}
