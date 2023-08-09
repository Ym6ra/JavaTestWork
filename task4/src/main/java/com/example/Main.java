package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main (String[] args){
        String fileName = args[0];
        System.out.println(fileName);
        int lines = 4;
        int[] array;
        array = new int[lines];
        try(BufferedReader linesCatch = new BufferedReader(new FileReader(fileName)))
        {
            String s;
            while((s=linesCatch.readLine())!=null){
                lines++;
            }
        }
                catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        try(BufferedReader linesArgs = new BufferedReader(new FileReader(fileName)))
        {
            String s;
            int i = 0;
            while((s=linesArgs.readLine())!=null){
                array[i] = Integer.valueOf(s);
                i++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        int sum = Arrays.stream(array).sum();
        int median = sum / array.length;
        int j = 0;
        int i = 0;
        while ( i < array.length){
            if (array[i]< median){
                array[i]+=1;
                j++;
            } else if(array[i]> median){
                array[i]-=1;
                j++;
            } else {
                i++;
            }
        }
        System.out.println(j);
    }
}