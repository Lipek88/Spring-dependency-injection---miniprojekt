package com.example.spring_initializer_miniprojekt.miniprojekt;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductParsingService {

    private ProductRepository productRepository1;
    private ProductRepository productRepository2;

    public ProductParsingService(@Qualifier("JTC") ProductRepository productRepository, @Qualifier("CTJ") ProductRepository productRepository2) {
        this.productRepository1 = productRepository;
        this.productRepository2 = productRepository;
        //TODO tutaj chyba musimy poprawic bo mamy odniesienie do tego samego repo
    }
}
