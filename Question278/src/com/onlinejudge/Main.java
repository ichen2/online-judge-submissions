package com.onlinejudge;

import java.io.IOException;

class Main {

    public static void main(String[] args) {
        int numProblems = Integer.parseInt(readLine(100000));
        String input;
        for (int i = 0; i < numProblems; i++) {
            input = readLine(10);
            String[] splitInput = input.split("\\s+");
            char type = splitInput[0].toCharArray()[0];
            int m = Integer.parseInt(splitInput[1]);
            int n = Integer.parseInt(splitInput[2]);
            int big = Math.max(m, n);
            int small = Math.min(m, n);
            switch (type) {
                case 'Q':
                case 'r':
                    System.out.println(small);
                    break;
                case 'k':
                    System.out.println(big * small / 2 + big * small % 2);
                    break;
                case 'K':
                    System.out.println((big % 2 == 0 ? (big / 2) : ((big + 1) / 2)) * (small % 2 == 0 ? (small / 2) : ((small + 1) / 2)));
                    break;
            }
        }
    }

    public static String readLine(int maxLg) {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String(lin, 0, lg));
    }
}
