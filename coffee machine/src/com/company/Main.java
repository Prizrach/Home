package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = null;

        System.out.println("Select the coffee machine");
        System.out.println("1 - Philips");
        System.out.println("2 - Siemens");
        System.out.println("3 - Mile");
        Scanner in = new Scanner(System.in);
        int coffeeMachineNumber = in.nextInt();
        switch (coffeeMachineNumber) {
            case 1:
                coffeeMachine = new Philips();
                break;
            case 2:
                coffeeMachine = new Siemens();
                break;
            case 3:
                coffeeMachine = new Mile();
                break;
        }
            coffeeMachine.showMenu();
    }
}
