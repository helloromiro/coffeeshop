package com.example.coffeeshop.mapper;

import com.example.coffeeshop.dto.CoffeeDTO;
import com.example.coffeeshop.model.Coffee;


public class CoffeeMapper {
    public static CoffeeDTO toCoffeeDTO(Coffee coffee) {
        return new CoffeeDTO(
                coffee.getId(),
                coffee.getCoffeeType(),
                coffee.getPrice()
        );
    }

    public static Coffee toCoffee(CoffeeDTO coffeeDTO) {
        return new Coffee(
                coffeeDTO.getId(),
                coffeeDTO.getCoffeeType(),
                coffeeDTO.getPrice()
        );
    }
}
