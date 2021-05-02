package questions.LinkedList;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class FindTheFirstNonRepeatingCharacterFromAStreamOfCharacters {
//    Q - https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
    public String solve(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();

        map.put(str.charAt(0), 1);
        queue.add(str.charAt(0));

        StringBuilder res = new StringBuilder();
        res.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            queue.add(str.charAt(i));

            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.remove();
            }

            if (queue.isEmpty()) {
                res.append('#');
            } else {
                res.append(queue.peek());
            }
        }
        return res.toString();
    }
}
