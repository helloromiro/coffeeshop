package com.example.coffeeshop.repository;

import com.example.coffeeshop.model.Coffee;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface CoffeeJpaRepository extends JpaRepository<Coffee, Long>, CoffeeRepository {

}
