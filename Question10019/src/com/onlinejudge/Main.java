package com.onlinejudge;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.print(findBs(1000));
        /*Scanner in = new Scanner(System.in);
        int inputSize = in.nextInt();
        in.nextLine();
        while(in.hasNextLine()) {
            int curr = in.nextInt();
            System.out.println(findBs(curr));
            inputSize--;
            in.nextLine();
        }
        in.close();*/
    }
    public static String findBs(int input) {
        return findB1(input) + " " + findB2(input);
    }
    public static int findB1(int input) {
        int numOnes = 0;
        while(input > 0) {
            numOnes += input % 2;
            input = input / 2;
        }
        return numOnes;
    }
    public static int findB2(int input) {
        int hexNum = 0;
        int coefficient = 1;
        while(input > 0) {
            hexNum += coefficient * (input % 10);
            coefficient *= 16;
            input /= 10;
        }
        return findB1(hexNum);
    }
}
