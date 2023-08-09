package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String circlefileName = args[0];
        String dotsfileName = args[1];
        int circleX = 0;
        int circleY = 0;
        int circleR = 0;
        try(BufferedReader circleArgs = new BufferedReader(new FileReader(circlefileName)))
        {
            Scanner sc = new Scanner(circleArgs);
            String a1 = sc.nextLine();
            String delimeter = " ";
            String[] a = a1.split(delimeter);
            circleX = Integer.valueOf(a[0]);
            circleY = Integer.valueOf(a[1]);
            //System.out.println(x);
            //System.out.println(y);
            String b1 = sc.nextLine();
            circleR = Integer.valueOf(b1);
            //System.out.println(r);
            sc.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        int lines = 0;
        try (BufferedReader dotsArgs = new BufferedReader(new FileReader(dotsfileName))) {
            String s;
            while ((s = dotsArgs.readLine()) != null) {
                lines++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(lines);
        try (BufferedReader dotsArgs = new BufferedReader(new FileReader(dotsfileName))) {
            Scanner sc = new Scanner(dotsArgs);
            String[] dotsArg = new String[lines];
            int i = 0;
            while (i<lines){
                dotsArg[i] = sc.nextLine();
                i++;
            }
            for (i = 0; i<lines; i++){
                String delimeter = " ";
                String[] a = dotsArg[i].split(delimeter);
                int dotX = Integer.valueOf(a[0]);
                int dotY = Integer.valueOf(a[1]);
                if ((dotX*dotX+circleX)+(dotY*dotY+circleY)< circleR*circleR+circleY+circleX ){
                    System.out.println("1");
                }else if ((dotX*dotX+circleX)+(dotY*dotY+circleY) == circleR*circleR+circleY+circleX ){
                    System.out.println("0");
                }else {
                    System.out.println("2");
                }
            }
            sc.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}