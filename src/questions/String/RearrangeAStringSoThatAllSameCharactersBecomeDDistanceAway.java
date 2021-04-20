package questions.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeAStringSoThatAllSameCharactersBecomeDDistanceAway {
//    Q - https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
    static class Pair implements Comparable<Pair> {
        char ch;
        int frequency;
        Pair(char ch, int frequency) {
            this.ch =  ch;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(Pair other) {
            if (this.frequency > other.frequency) {
                return 1;
            } else if (this.frequency < other.frequency) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public String solve(String s, int d) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        fillFrequencyMap(s, frequencyMap);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (char ch : frequencyMap.keySet()) {
            Pair pair = new Pair(ch, frequencyMap.get(ch));
            pq.add(pair);
        }

        char[] res = new char[s.length()];
        Arrays.fill(res, '\0');

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            char x = pair.ch;
            int frequency = pair.frequency;

            int freePosition = 0;

            while (res[freePosition] != '\0') freePosition++;

            for (int i = 0; i < frequency; i++) {
                int index = freePosition + i * d;
                if (index >= res.length) return "Not Possible";
                res[index] = x;
            }
        }

        return new String(res);
    }
    private void fillFrequencyMap(String s, HashMap<Character, Integer> frequencyMap) {
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
    }
}
