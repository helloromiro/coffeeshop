package com.example.coffeeshop.controller;

import com.example.coffeeshop.dto.CoffeeDTO;
import com.example.coffeeshop.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/coffee")
public class CoffeeController {


    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CoffeeDTO> createCoffee(@RequestBody CoffeeDTO coffeeDTO) {
        CoffeeDTO savedCoffee = coffeeService.createCoffee(coffeeDTO);
        return new ResponseEntity<>(savedCoffee, HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<CoffeeDTO> getCoffee(@PathVariable("id") Long coffeeId) {
        CoffeeDTO coffeeDTO = coffeeService.getCoffeeById(coffeeId);
        return new ResponseEntity<>(coffeeDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/") // GET /api/v1/coffee/?page=0&size=10&sort=name,asc
    public Page<CoffeeDTO> getAllCoffees(Pageable pageable) {
        return coffeeService.getAllCoffees(pageable);
    }
}
