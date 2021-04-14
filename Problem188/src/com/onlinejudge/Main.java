package com.onlinejudge;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
	    String next;
	    while((next = readLine(100)) != null && !next.equals("")) {
	        String[] words = next.split("[ ]+");
	        int n = words.length;
	        long[] values = new long[n];
	        for(int i = 0; i < n; i++) {
	            values[i] = getValue(words[i]);
            }
	        int C = 1;
	        while(true) {
                boolean[] filled = new boolean[n];
                boolean done = true;
	            for(long value : values) {
	                int index = (int) ((C / value) % n);
	                if(filled[index]) {
	                    C++;
	                    done = false;
	                    break;
                    }
	                else {
	                    filled[index] = true;
                    }
                }
	            if(done) {
                    break;
                }
            }
	        System.out.println(next);
	        System.out.println(C);
	        System.out.println();
        }
    }
    public static long getValue(String s) {
        long value = 0;
        for(int i = 0; i < s.length(); i++) {
            value += (s.charAt(i) - 'a' + 1) * Math.pow(32, s.length() - i - 1);
        }
        return value;
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
// a bee  see   dee
// 1 2213 19621 4261
// 3 2    0     1