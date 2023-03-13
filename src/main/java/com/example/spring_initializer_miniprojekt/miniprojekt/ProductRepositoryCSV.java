package com.example.spring_initializer_miniprojekt.miniprojekt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("JTC")
public class ProductRepositoryCSV implements ProductRepository {

    public ProductRepositoryCSV() {
        System.out.println("utworzenie product repositoryCSV");
    }
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void parse() {
        FileWriter fileWriter = null;
        try {
            System.out.println("jestem w metodzie pardowania na csv");
            JsonNode objects = objectMapper.readValue(new File("src/main/resources/product.json"), JsonNode.class);
            fileWriter = new FileWriter("src/main/resources/product.csv");
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
