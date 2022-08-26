package com.az._42;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int solution(int[] entrances, int[] exits, int[][] path) {
        int[][] graph = new int[path.length + 2][path.length + 2];
        for (int i = 1; i < graph.length - 1; i++) {
            System.arraycopy(path[i - 1], 0, graph[i], 1, graph.length - 1 - 1);
        }

        for (int entrance : entrances) {
            graph[0][entrance+1] = Integer.MAX_VALUE;
        }

        for (int exit : exits) {
            graph[exit+1][graph.length - 1] = Integer.MAX_VALUE;
        }

        int[] positivePath;
        int maxFlow = 0;
        while ((positivePath = findPositivePath(graph)) != null) {
            int flow = Integer.MAX_VALUE;
            int curr = graph.length -1;
            while (curr != 0) {
                int prev = positivePath[curr];
                flow = Math.min(flow, graph[prev][curr]);
                curr = prev;
            }

            curr = graph.length -1;
            while (curr != 0) {
                int prev = positivePath[curr];
                graph[prev][curr] -= flow;
                graph[curr][prev] += flow;
                curr = prev;
            }
            maxFlow += flow;
        }
        return maxFlow;
    }

    private static int[] findPositivePath(int[][] graph) {
        int[] result = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next = 0; next < graph.length; next++) {
                if (!visited[next] && graph[curr][next] > 0) {
                    result[next] = curr;
                    if (next == graph.length - 1) {
                        // Reached the sink
                        return result;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return null;
    }
}
