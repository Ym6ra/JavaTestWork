package com.example;

import java.io.FileReader;
import com.example.model.Tests;
import com.google.gson.Gson;

public class TestsParser {

    public Tests parse(String arg) {

        String testsJsonPath = arg;

        Gson gson = new Gson();
        Tests tests = new Tests();
        try (FileReader reader = new FileReader(testsJsonPath)) {
            tests = gson.fromJson(reader,tests.getClass());
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return tests;
    }

}
