package com.onlinejudge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        List<List<String>> parsedInput = parseInput();
        for(List<String> deck : parsedInput) {
            playTheGame(deck);
        }
    }
    public static void playTheGame(List<String> input) {
        int exposed = 0;
        int stackIndex = 12;
        String card = "";
        // create list of 13 stacks
        List<Stack<String>> stacks = new ArrayList<>(13);
        for(int i = 0; i < 13; i++) {
            stacks.add(new Stack<>());
        }
        // for each card, put it into it's stack
        for(int i = 0; i < 52; i++) {
            stacks.get(i % 13).push(input.get(51-i));
        }
        // while all stacks aren't empty and current stack isn't empty
        while(exposed < 52 && stacks.get(stackIndex).size() > 0) {
            // pop card off current stack
            // set current stack to the stack of that card's value
            card = stacks.get(stackIndex).pop();
            stackIndex = getCardValue(card.charAt(0)) - 1;
            //System.out.println(stackIndex);
            exposed++;
        }
        // return number of cards flipped and the last flipped card
        String output = exposed + "," + card;
        if(exposed < 10) {
            output = "0" + output;
        }
        System.out.println(output);
    }
    public static int getCardValue(char card) {
        if(card >= '2' && card <= '9') {
            return card - '0';
        }
        else {
            switch(card) {
                case 'A':
                    return 1;
                case 'T':
                    return 10;
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
            }
        }
        return -1;
    }
    public static List<List<String>> parseInput() {
        List<List<String>> parsedInput = new ArrayList<>();
        List<String> currentDeck = new ArrayList<>(52);
        String next;
        int count = 0;
        while((next = readNext()) != null && !next.equals("#")) {
            if(!next.equals("")) {
                currentDeck.add(next);
                count++;
            }
            if(count >= 52) {
                count = 0;
                parsedInput.add(currentDeck);
                currentDeck = new ArrayList<>(52);
            }
        }
        return parsedInput;
    }
    public static String readNext() {
        int maxLg = 10;
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == ' ') || (car == '\n')) break;
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