package questions.Greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeCharactersInAStringSuchThatNoTwoAdjacentAreSame {
    //    Q - https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
    static class CharNode implements Comparable<CharNode> {
        char ch;
        int frequency;
        public CharNode(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(CharNode o) {
            if (this.frequency < o.frequency) return 1;
            else if (this.frequency > o.frequency) return -1;
            else return 0;
        }
    }

    public String solve(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<CharNode> pq = new PriorityQueue<>();

        for (char key : map.keySet()) {
            CharNode node = new CharNode(key, map.get(key));
            pq.add(node);
        }

        StringBuilder res = new StringBuilder();

        CharNode prev = new CharNode('$', -1);

        while (!pq.isEmpty()) {
            CharNode node = pq.remove();
            res.append(node.ch);

            if (prev.frequency > 0) {
                pq.add(prev);
            }
            node.frequency--;
            prev = node;
        }

        return res.toString().length() == str.length() ? res.toString() : "NOT POSSIBLE";
    }
}
