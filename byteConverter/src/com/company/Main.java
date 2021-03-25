package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner bkb = new Scanner(System.in);
        String str = null;
        long number = 0;
        do {
            System.out.println("Please enter number from 0 to 10^6");
            number = in.nextLong();
            if (number < 0 || number > 10000000) {
                System.out.println("Error.");
            }
        }
        while (number < 0 || number > 10000000);

        do {
            System.out.println("Please enter b or kb");
            str = bkb.nextLine();
            if (str.equals("kb") == false) {
                if (str.equals("b") == false) {
                    System.out.println("Error.");
                }
            }
        }
        while (str.equals("kb") == false || str.equals("kb") == false);

        switch (str) {
            case "b":
                System.out.println(number + " megabytes = " + number * 1048576 + " bytes");
                break;
            case "kb":
                System.out.println(number + " megabytes = " + number * 1024 + " kbytes");
                break;
            default:
        }
    }
}





