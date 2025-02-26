package org.example;

import java.util.Scanner;

public class Cal {

    public static int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gimme the loot");
        int a = sc.nextInt();
        System.out.println("Gimme the loot");
        int b = sc.nextInt();
        System.out.println("Looted successfully: " + sum(a,b));
    }

}


