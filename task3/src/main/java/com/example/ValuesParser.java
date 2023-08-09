package com.example;

import java.io.FileReader;
import com.example.model.Values;
import com.google.gson.Gson;

public class ValuesParser {

public Values parse(String arg) {

        String valuesJsonPath = arg;

        Gson gson = new Gson();
        Values values = new Values();
        try (FileReader reader = new FileReader(valuesJsonPath)) {
            values = gson.fromJson(reader,values.getClass());
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return values;
    }
}

