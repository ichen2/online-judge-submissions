package com.onlinejudge;

import java.io.IOException;

class Main {

    public static void main(String[] args) {
        String curr = "";
	    while(!(curr = readLine(51)).equals("#")) {
            System.out.println(getSuccessor(curr));
        }
    }
    /*
        for each character
        if that character isn't greater than all the previous chars
        lower that character to the next lowest char
        fill the rest of the string with the remaining chars in alphabetic order
     */
    public static String getSuccessor(String input) {
        int[] characterCount = new int[26];
        char lowestCharacter = 'a';
        for(int i = input.length()-1; i >= 0; i--) {
            char curr = input.charAt(i);
            //System.out.print(curr);
            characterCount[curr - 'a']++;
            if(curr < lowestCharacter) {
                //System.out.print("!");
                for(int j = curr - 'a' + 1; j < 26; j++) {
                    if(characterCount[j] > 0) {
                        characterCount[j]--;
                        return input.substring(0,i) + (char)(j + 'a') + getAlphabeticString(characterCount);
                    }
                }
            }
            else {
                lowestCharacter = curr;
            }
        }
        return "No Successor";
    }
    public static String getAlphabeticString(int[] counts) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < counts.length; i++) {
            for(int j = 0; j < counts[i]; j++) {
                builder.append((char)(i + 'a'));
            }
        }
        return builder.toString();
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
/*
a: 3, 2: b, 1: c
aaabbc
aaabcb
aaacbb
aababc
aabbac
aabbca
aabcab
aabcba
aacabb
aacbab
aacbba
aa

iterate until you reach a letter that's not alphabetic
decrease the letter's value to the next lowest and rearrange the rest of the string in alphabetic order


 */