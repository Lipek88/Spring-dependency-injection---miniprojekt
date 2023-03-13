package com.example.spring_initializer_miniprojekt.miniprojekt;

import org.springframework.stereotype.Component;

@Component
public class ProductParsingController {
    ProductParsingService productParsingService;
    public ProductParsingController(ProductParsingService productParsingService) {
        System.out.println("jestem Parsing Controller");
        this.productParsingService = productParsingService;
    }


}
