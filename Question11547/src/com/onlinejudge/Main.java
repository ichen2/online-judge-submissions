package com.onlinejudge;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int cases = in.nextInt();
	    for(int i = 0; i < cases; i++) {
            System.out.println(calculate(in.nextInt()));
        }
    }
    public static String calculate(long input) {
        input *= 63;
        input += 7492;
        input *= 5;
        input -= 498;
        String s = Long.toString(input);
        return s.substring(s.length()-2, s.length()-1);
    }
}
