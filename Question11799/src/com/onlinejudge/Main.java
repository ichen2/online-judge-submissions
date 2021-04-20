package com.onlinejudge;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for(int i = 1; i <= numCases; i++) {
            int numStudents = in.nextInt();
            int max = 0;
            for(int j = 0; j < numStudents; j++) {
                max = Math.max(max, in.nextInt());
            }
            System.out.printf("Case %d: %d\n", i, max);
        }
    }
}
