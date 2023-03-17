package com.example.spring_initializer_miniprojekt.miniprojekt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("CTJ")
public class ProductRepositoryJSON implements ProductRepository {

    @Override
    public void parse(){
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/product.csv"));
            ArrayNode productsArray = JsonNodeFactory.instance.arrayNode();
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(",");
                ObjectNode json = JsonNodeFactory.instance.objectNode();
                json.put("name", data[0]);
                json.put("price", Double.parseDouble(data[1]));
                json.put("quantity", Integer.parseInt(data[2]));
                productsArray.add(json);
            }
            csvReader.close();
            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/product.json"), productsArray);

            String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            String fileName = "src/main/resources/product-out-" + timestamp + ".json";
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), productsArray);

            System.out.println("Parsowanie na plik .json zakończone SUKCESEM" + fileName);
        } catch (IOException e) {
            System.out.println("Parsowanie na plik .csv się nie powiodło");
        }
    }
}
