package com.onlinejudge;

import java.io.*;

class Main {
    public static void main(String[] args) {
        int inputSize = readInt();
        String[] output = new String[inputSize];
        for(int i = 0; i < inputSize; i++) {
            int curr = readInt();
            output[i] = findBs(curr);
        }
        for(String s : output) {
            System.out.println(s);
        }
    }
    public static int readInt() {
        return Integer.parseInt(readLine(5));
    }
    public static String readLine(int maxLg) {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
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
