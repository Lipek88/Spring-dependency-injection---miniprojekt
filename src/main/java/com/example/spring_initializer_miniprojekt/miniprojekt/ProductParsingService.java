package com.example.spring_initializer_miniprojekt.miniprojekt;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductParsingService {
    private ProductRepository productRepository1;
    private ProductRepository productRepository2;

    public ProductParsingService(ProductRepository productRepository, ProductRepository productRepository2) {
        this.productRepository1 = productRepository;
        this.productRepository2 = productRepository;
    }
}
