package org.example;

public class timeCalculator {
    public static void main(String[] args) {
        System.out.println("Time needs " + Calc(100.0, 100.0));
    }

    public static double Calc(double x, double v){
        return x/v;
    }
}
