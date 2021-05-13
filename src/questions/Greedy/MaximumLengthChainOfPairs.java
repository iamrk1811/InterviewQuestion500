package questions.Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        return a.x - b.x;
    }
}
public class MaximumLengthChainOfPairs {
//    Q - https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
    public int solve(Pair[] arr) {
        Arrays.sort(arr, new PairComparator());

        int[] dp = new int[arr.length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i].x > arr[j].y) {
                    count = Math.max(count, dp[j]);
                }
            }
            dp[i] = count + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
