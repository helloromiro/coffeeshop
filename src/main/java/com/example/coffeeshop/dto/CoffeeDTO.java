package com.example.coffeeshop.dto;

import com.example.coffeeshop.enums.CoffeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDTO {

    private Long id;
    private CoffeeType coffeeType;
    private Integer price;

}
