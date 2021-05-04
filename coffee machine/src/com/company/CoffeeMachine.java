package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class CoffeeMachine implements Interface {
    private int maxAmountOfWater;
    private int maxAmountOfCoffee;
    public int amountOfWater;
    public int amountOfCoffee;
    public int americanoWater = 40;
    public int americanoCoffee = 22;
    public int espressoWater = 15;
    public int espressoCoffee = 15;
    public int doubleEspressoWater = 30;
    public int doubleEspressoCoffee = 32;

    public void equating(int maxAmountOfWater, int maxAmountOfCoffee) {
        this.maxAmountOfWater = maxAmountOfWater;
        this.maxAmountOfCoffee = maxAmountOfCoffee;
        amountOfWater = maxAmountOfWater;
        amountOfCoffee = maxAmountOfCoffee;
    }

    public int getMaxAmountOfWater() {
        return maxAmountOfWater;
    }

    public void setMaxAmountOfWater(int maxAmountOfWater) {

        this.maxAmountOfWater = maxAmountOfWater;
    }

    public int getMaxAmountOfCoffee() {

        return maxAmountOfCoffee;
    }

    public void setMaxAmountOfCoffee(int maxAmountOfCoffee) {

        this.maxAmountOfCoffee = maxAmountOfCoffee;
    }


    @Override
    public void showAmountOfWaterAndAmountOfCoffee() {
        System.out.println("Water = " + amountOfWater);
        System.out.println("Coffee = " + amountOfCoffee);
    }

    @Override
    public void cookAmericano() {
        cookCoffee(americanoCoffee, americanoWater);
    }

    @Override
    public void cookEspresso() {
        cookCoffee(espressoCoffee, espressoWater);
    }

    @Override
    public void cookDoubleEspresso() {
        cookCoffee(doubleEspressoCoffee, doubleEspressoWater);
    }

    @Override
    public void fillTheCoffeeTank() {
        fillTheTank(amountOfCoffee, maxAmountOfCoffee);
        amountOfCoffee = maxAmountOfCoffee;
    }

    @Override
    public void fillTheWaterTank() {
        fillTheTank(amountOfWater, maxAmountOfWater);
        amountOfWater = maxAmountOfWater;
    }


    @Override
    public void information() {
        String name = this.getClass().getSimpleName();
        System.out.println(name);
        System.out.println("Water tank " + maxAmountOfWater);
        System.out.println("Coffee tank " + maxAmountOfCoffee);
    }

    @Override
    public void turnOffTheCoffeeMachine() {
        System.exit(0);
    }

    public void cookCoffee(int coffee, int water) {
        if (amountOfCoffee < coffee) {
            System.out.println("Fill the Coffee tank");
        }
        if (amountOfWater < water) {
            System.out.println("Fill the water tank");
        }
        if (amountOfCoffee >= coffee && amountOfWater >= water) {
            amountOfCoffee -= coffee;
            amountOfWater -= water;
            System.out.println("Coffee is ready");
        }
    }

    public void fillTheTank(int amountOfWaterOrCoffee, int maxAmountOfWaterOrCoffee) {
        if (amountOfWaterOrCoffee == maxAmountOfWaterOrCoffee) {
            System.out.println("The tank is already full");
        } else {
            amountOfWaterOrCoffee = maxAmountOfWaterOrCoffee;
            System.out.println("The tank is full");
        }
    }

    public void showMenu(){
        int menuButton = 0;
        while (true) {
            System.out.println();
            System.out.println("1 - Show amount of the water and amount of the coffee");
            System.out.println("2 - Cook Americano");
            System.out.println("3 - Cook Espresso");
            System.out.println("4 - Cook Double espresso");
            System.out.println("5 - Fill the water tank");
            System.out.println("6 - Fill the coffee tank");
            System.out.println("7 - Information");
            System.out.println("8 - Turn off the Coffee machine");
            Scanner in = new Scanner(System.in);
            try {
                menuButton = in.nextInt();
            } catch (NoSuchElementException e) {

            }
                switch (menuButton) {
                    default:
                        System.out.println("Wrong number!");
                        break;
                    case 1:
                        showAmountOfWaterAndAmountOfCoffee();
                        break;
                    case 2:
                        cookAmericano();
                        break;
                    case 3:
                        cookEspresso();
                        break;
                    case 4:
                        cookDoubleEspresso();
                        break;
                    case 5:
                        fillTheWaterTank();
                        break;
                    case 6:
                        fillTheCoffeeTank();
                        break;
                    case 7:
                        information();
                        break;
                    case 8:
                        turnOffTheCoffeeMachine();
                }
            }
        }
    }
