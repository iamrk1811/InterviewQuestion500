package questions.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    static class Pair implements Comparable<Pair> {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair obj) {
            if (this.first + this.second > obj.first + obj.second) {
                return 1;
            } else if (this.first + this.second < obj.first + obj.second) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public List<List<Integer>> solve(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 ) {
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new Pair(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            Pair pair = pq.remove();
            List<Integer> temp = new ArrayList<>();
            temp.add(pair.first);
            temp.add(pair.second);

            list.add(temp);
        }
        return list;
    }
}
