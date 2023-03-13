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
        System.out.println("Jestem w ParsinController");
        this.productParsingService = productParsingService;
    }
    @PostConstruct
    public void chooseParsingDirection() throws IOException {
        System.out.println("jestem w choseParsing");
        System.out.println("1 - CSV to JSON");
        System.out.println("2 - JSON to CSV");
        int liczba = scanner.nextInt();
        boolean choice = liczba == 1;
        if(choice){
            productParsingService.productRepository1.parse();
        }else {
            productParsingService.productRepository2.parse();
        }
    }


}
