package com.example.spring_initializer_miniprojekt.miniprojekt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("JTC")
public class ProductRepositoryCSV implements ProductRepository {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void parse() {
        FileWriter fileWriter = null;
        try {
            JsonNode objects = objectMapper.readValue(new File("src/main/resources/product.json"), JsonNode.class);
//            fileWriter = new FileWriter("src/main/resources/product.csv");

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            String timestamp = now.format(formatter);
            fileWriter = new FileWriter("src/main/resources/product-out-" + timestamp + ".csv");

//        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("name","price","quantity"));
            for (JsonNode node : objects) {
                String name = node.get("name").asText();
                double price = node.get("price").asDouble();
                int quantity = node.get("quantity").asInt();
                fileWriter.append(name + "," + price + "," + quantity + "\n");
            }
            System.out.println("Parsowanie na plik .csv zakończone SUKCESEM");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Parsowanie na plik .csv się nie powiodło");
        }
    }
}
