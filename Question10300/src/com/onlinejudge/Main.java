package com.onlinejudge;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int numCases = in.nextInt();
	    for(int i = 0; i < numCases; i++) {
	        long total = 0;
	        int numFarmers = in.nextInt();
	        for(int j = 0; j < numFarmers; j++) {
	            long space = in.nextInt();
	            in.nextInt();
	            long animals = in.nextInt();
	            total += space * animals;
            }
	        System.out.println(total);
        }
    }
}
