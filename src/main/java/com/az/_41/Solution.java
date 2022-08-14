package com.az._41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {

    static class State {
        private final int[][] times;
        private final int remainingTime;
        private final boolean[] saved;
        private final int room;

        public State(int[][] times, int remainingTime) {
            this(times, remainingTime, new boolean[times.length - 2], 0);
        }

        public State(int[][] times, int remainingTime, boolean[] saved, int room) {
            this.times = times;
            this.remainingTime = remainingTime;
            this.saved = saved;
            this.room = room;
        }

        public State goToRoom(int n) {
            int delta = times[this.room][n];
            boolean[] newSaved = Arrays.copyOf(this.saved, this.saved.length);
            if (room > 0 && room < times.length - 1) {
                newSaved[room - 1] = true;
            }

            return new State(this.times, this.remainingTime - delta, newSaved, n);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return room == state.room && Arrays.equals(saved, state.saved);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(room);
            result = 31 * result + Arrays.hashCode(saved);
            return result;
        }

        @Override
        public String toString() {
            return room + ":" + Arrays.toString(saved) + "@" + remainingTime;
        }
    }

    static Map<State, State> bestStates = new HashMap<>();
    static Map<State, State> currentPath = new HashMap<>();

    static boolean[] bestSaved = null;
//    static Deque<State> traverseStack = new LinkedList<>();

    public static int[] solution(int[][] times, int times_limit) {
        traverse(new State(times, times_limit));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < bestSaved.length; i++) {
            if (bestSaved[i]) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static void traverse(State current) {
        State existingState = bestStates.get(current);
        if (existingState != null && current.remainingTime <= existingState.remainingTime) {
            return;
        }

        State existingPathState = currentPath.get(current);
        if (existingPathState != null) {
            if (current.remainingTime > existingPathState.remainingTime) {
                // Loop detected, and we can generate as much time as we need.
                bestSaved = new boolean[current.saved.length];
                Arrays.fill(bestSaved, true);
                return;
            }
        }

        bestStates.put(current, current);

        if (current.remainingTime >= 0 && current.room == current.times.length - 1) {
            bestSaved = chooseBest(bestSaved, current.saved);
        }

        for (int i = 0; i < current.times.length; i++) {
            currentPath.put(current, current);
            if (i != current.room) {
                traverse(current.goToRoom(i));
            }
            currentPath.remove(current);
        }
    }

    private static boolean[] chooseBest(boolean[] s1, boolean[] s2) {
        if (s1 == null) return s2;
        if (s2 == null) return s1;

        int n1 = 0;
        for (boolean s : s1) {
            if (s) n1++;
        }

        int n2 = 0;
        for (boolean s : s2) {
            if (s) n2++;
        }

        if (n1 > n2) return s1;
        if (n2 > n1) return s2;

        for (int i = 0; i < s1.length; i++) {
            boolean a = s1[i];
            boolean b = s2[i];
            if (a && !b) return s1;
            if (!a && b) return s2;
        }
        return s1;
    }
}
