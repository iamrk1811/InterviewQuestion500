package questions.SearchAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSumProblem {
//    Q - https://leetcode.com/problems/4sum/
    public List<List<Integer>> solve(int[] arr, int target) {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();

        HashSet<String> set = new HashSet<>();


        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int low = j + 1, high = n - 1;

                int newTarget = target - (arr[i] + arr[j]);
                while (low < high) {
                    int sum = arr[low] + arr[high];
                    if (sum == newTarget) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);

                        String str = String.valueOf(arr[i]) + String.valueOf(arr[j]) + String.valueOf(arr[low]) + String.valueOf(arr[high]);
                        if (set.add(str))
                            res.add(temp);
                        low++;
                        high--;
                    } else if (sum < newTarget) {
                        low++;
                    } else
                        high--;
                }
            }
        }
        return res;
    }
}
