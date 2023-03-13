package com.example.spring_initializer_miniprojekt.miniprojekt;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductParsingService {

    @Qualifier("JTC")
    ProductRepository productRepository1;

    @Qualifier("CTJ")
    ProductRepository productRepository2;

    public ProductParsingService(@Qualifier("JTC") ProductRepository productRepository1, @Qualifier("CTJ") ProductRepository productRepository2) {
        this.productRepository1 = productRepository1;
        this.productRepository2 = productRepository2;
    }


//    @PostConstruct
//    public void startParsing(boolean choice) throws IOException {
//
//        System.out.println("jestem w metodzie start parsing");
//        productRepository1.parse();
//        productRepository2.parse();
//
//    }
}
