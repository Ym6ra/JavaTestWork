package com.example;

import com.example.model.Tests;
import com.example.model.Test;
import com.example.model.Values;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;



public class Main {
    public static void main(String[] args) {
        
        String testsJsonPath = args[0];

        TestsParser parser = new TestsParser();
        Tests tests = parser.parse(testsJsonPath);

        String valuesJsonPath = args[1];

        ValuesParser vparser = new ValuesParser();
        Values values = vparser.parse(valuesJsonPath);

        Map<Long, String> valuesMap = values.getValuesMap();
        ArrayList<Test> arrayTest = tests.getTests();
        fillValue(valuesMap, arrayTest);
        tests.setTests(arrayTest);
        
        try {
            File file = new File("report.json");
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(new Gson().toJson(tests));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void fillValue(Map<Long, String> valuesMap, ArrayList<Test> arrayTest) {
        for (Test item : arrayTest) {
            item.setValue(valuesMap.get(item.getId()));
            if (item.getValues() != null) {
                fillValue(valuesMap, item.getValues());
            }
        }
    }


}