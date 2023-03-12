package com.example.spring_initializer_miniprojekt.miniprojekt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
@Primary
public class ProductRepositoryCSV implements ProductRepository {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void parse() throws IOException {
        JsonNode objects = objectMapper.readValue(new File("src/main/resources/prod.json"), JsonNode.class);
        FileWriter fileWriter = new FileWriter("src/main/resources/product.csv");
        for (JsonNode node : objects) {
            String name = node.get("name").asText();
            double price = node.get("price").asDouble();
            int quantity = node.get("quantity").asInt();
            fileWriter.append(name + "," + price + "," + quantity + "\n");
        }
        fileWriter.close();
    }
}
