package com.onlinejudge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        String next;
        while((next = readLine(10)) != null && !next.equals("") && !next.equals("0")) {
            String[] input = next.split(" ");
            List<Integer> outputList = new ArrayList<>();
            int numerator = Integer.parseInt(input[0]);
            int denominator = Integer.parseInt(input[1]);
            do {
                outputList.add(numerator / denominator);
                int temp = denominator;
                denominator = numerator % denominator;
                numerator = temp;
            } while(numerator != 1);
            StringBuilder output = new StringBuilder();
            output.append('[');
            for(int i = 0; i < outputList.size(); i++) {
                output.append(outputList.get(i));
                if(i == 0) output.append(';');
                else if(i != outputList.size() - 1) output.append(',');
            }
            output.append(']');
            System.out.println(output.toString());
        }
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
