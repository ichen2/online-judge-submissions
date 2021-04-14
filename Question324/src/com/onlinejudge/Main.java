package com.onlinejudge;

import java.io.IOException;
import java.math.BigInteger;

class Main {

    public static void main(String[] args) {
        String next;
        while((next = readLine(10)) != null && !next.equals("") && !next.equals("0")) {
            int value = Integer.parseInt(next);
            BigInteger factorial = factorial(value);
            int[] digits = countDigits(factorial);
            System.out.println(value + "! --");
            System.out.println(getDigitsString(digits));
        }
    }
    public static BigInteger factorial(int n) {
        BigInteger value = BigInteger.ONE;
        for(int i = 2; i <= n; i++) {
            value = value.multiply(BigInteger.valueOf(i));
        }
        return value;
    }
    public static int[] countDigits(BigInteger num) {
        int[] digits = new int[10];
        for(char digit : num.toString().toCharArray()) {
            digits[digit - '0']++;
        }
        return digits;
    }
    public static String getDigitsString(int[] digits) {
        StringBuilder digitsString = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            if(i == 0) {
                digitsString.append("   ");
            }
            else if(i == 5) {
                digitsString.append("\n   ");
            }
            else {
                digitsString.append("    ");
            }
            digitsString.append("(" + i + ")");
            digitsString.append(String.format("%5d", digits[i]));
        }
        return digitsString.toString();
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
}
