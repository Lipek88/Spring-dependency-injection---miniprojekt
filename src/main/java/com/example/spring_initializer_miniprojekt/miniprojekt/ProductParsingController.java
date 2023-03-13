package com.example.spring_initializer_miniprojekt.miniprojekt;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class ProductParsingController {
    ProductParsingService productParsingService;
    Scanner scanner = new Scanner(System.in);
    public ProductParsingController(ProductParsingService productParsingService) {
        this.productParsingService = productParsingService;
    }
    @PostConstruct
    public void chooseParsingDirection() throws IOException {
        System.out.println("""
                Choose file parsing direction:
                1 - CSV to JSON"
                2 - JSON to CSV
                """);
        int number = scanner.nextInt();
        if(number == 1){
            productParsingService.productRepository1.parse();
        }else {
            productParsingService.productRepository2.parse();
        }
    }


}
