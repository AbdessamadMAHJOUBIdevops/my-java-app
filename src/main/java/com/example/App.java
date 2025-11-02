package com.example;

/**
 * Hello world!
 */
public class App {

    // A simple function we can test
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App myApp = new App();
        System.out.println("Hello Jenkins!");
        System.out.println("2 + 3 = " + myApp.add(2, 3));
    }
}
