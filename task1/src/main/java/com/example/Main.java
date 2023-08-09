package com.example;

import java.util.Scanner;

public class Main {
     public static void main(String[] args){
        Scanner myInput = new Scanner(System.in);
        System.out.print("Требуемое число элементов в массиве: ");
        int n = myInput.nextInt();
        int[] arr = new int[n];
        //System.out.print("Полученый массив: ");
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
                //System.out.print(arr[i]);
            }
        //System.out.print("\n");
        System.out.print("Необходимая длина интервала: ");
        int m = myInput.nextInt();
        System.out.print("Путь: ");
        int i = 0;
            do {
                System.out.print(arr[i]);
                i = (i+m-1)%n;
            } while (i!=0);
        myInput.close();
    }
}