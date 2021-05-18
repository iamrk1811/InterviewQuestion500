package questions.OrderStatisticsHeapHash;
import java.util.*;
public class CountDistinctElementsInEveryWindowOfSizeK {
    //    Q - https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
    public ArrayList<Integer> countDistinct(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while (j < n) {
            if (j - i + 1 < k) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                j++;
            } else {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                res.add(map.size());

                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
