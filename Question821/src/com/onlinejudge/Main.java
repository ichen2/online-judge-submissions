package com.onlinejudge;

import java.io.IOException;
import java.util.*;

class Main {

    static int[][] dp;
    static boolean[][] adjacencyMatrix;
    static int max;

    public static void main(String[] args) {
        String next;
        int count = 1;
        while((next = readLine(100 * 100)) != null && !next.equals("") && !next.equals("0 0")) {
            String[] input = next.split("\\s+");
            int[] parsedInput = new int[input.length - 2];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < input.length-2; i+= 2) {
                int left = Integer.parseInt(input[i]);
                int right = Integer.parseInt(input[i+1]);
                map.putIfAbsent(left, map.keySet().size());
                map.putIfAbsent(right, map.keySet().size());
                parsedInput[i] = map.get(left);
                parsedInput[i+1] = map.get(right);
            }
            max = map.size();
            adjacencyMatrix = new boolean[max][max];
            for(int i = 0; i <= parsedInput.length-2; i+= 2) {
                adjacencyMatrix[parsedInput[i]][parsedInput[i+1]] = true;
            }

            dp = new int[max][max];
            for(int i = 0; i < max; i++) {
                for(int j = 0; j < max; j++) {
                    dp[i][j] = i == j ? 0 : adjacencyMatrix[i][j] ? 1 : -1;
                }
            }
            double totalDistance = 0;
            for(int i = 0; i < max; i++) {
                for(int j = 0; j < max; j++) {
                    totalDistance += getDistance(i, j, new HashSet<>());
                }
            }
            System.out.printf("Case %d: average length between pages = %.3f clicks\n", count, totalDistance / (max * (max - 1)));
            count++;
        }
    }

    public static int getDistance(int start, int end, Set<Integer> visited) {
        if(start == end) return 0;
        if(visited.contains(start)) return -1;
        if(dp[start][end] != -1) return dp[start][end];
        visited.add(start);
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < max; i++) {
            if(adjacencyMatrix[start][i]) {
                int distance = getDistance(i, end, new HashSet<>(visited));
                if(distance != -1) minDistance = Math.min(distance + 1, minDistance);
            }
        }
        dp[start][end] = minDistance == Integer.MAX_VALUE ? -1 : minDistance;
        return dp[start][end];
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
