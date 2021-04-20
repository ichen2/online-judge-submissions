package com.onlinejudge;

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int maxCycleLength = getMaxCycleLength(num1, num2);
            System.out.printf("%d %d %d\n", num1, num2, maxCycleLength);
        }
    }
    public static int getMaxCycleLength(int num1, int num2) {
        int max = 0;
        for(int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++) {
            int curr = i;
            int count = 1;
            while(curr > 1) {
                curr = (curr % 2 == 0) ? curr / 2 : 3 * curr + 1;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
    public static String readLine(int maxLg) {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

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
