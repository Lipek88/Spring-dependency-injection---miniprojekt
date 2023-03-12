package com.example.spring_initializer_miniprojekt.miniprojekt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProductRepositoryCSV implements ProductRepository {
    @Override
    public void parse() {

    }
}
