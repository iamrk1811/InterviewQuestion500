package questions.Backtracking;

import java.util.ArrayList;

public class PartitionOfASetIntoKSubsetsWithEqualSum {
//    Q - https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/
    public boolean solve(int[] arr, int k) {
        if (arr.length < k || arr.length == 0) {
            return false;
        }
        long sum = 0;
        for (int val : arr) sum += val;
        if (sum % k != 0) return false;

        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            set.add(new ArrayList<>());
        }

        int[] subsetSum = new int[k];

        int target = (int) sum / k;
        return solution(arr, 0, 0, k, target, set, subsetSum);
    }
    private boolean solution(int[] arr, int index, int countOfSubset, int k, int target, ArrayList<ArrayList<Integer>> set, int[] subsetSum) {
        if (index ==  arr.length) {
            if (countOfSubset == k) {
                boolean isAllEqual = true;
                for (int val : subsetSum) {
                    if (val != target) {
                        isAllEqual = false;
                        break;
                    }
                }
                return isAllEqual;
            }
            return false;
        }
        boolean isPossible = false;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).size() > 0) {
                set.get(i).add(arr[index]);
                subsetSum[i] += arr[index];
                isPossible = isPossible || solution(arr, index + 1, countOfSubset, k, target, set, subsetSum);
                subsetSum[i] -= arr[index];
                set.get(i).remove(set.get(i).size() - 1);
            } else {
                set.get(i).add(arr[index]);
                subsetSum[i] += arr[index];
                isPossible = isPossible || solution(arr, index + 1, countOfSubset + 1, k, target, set, subsetSum);
                subsetSum[i] -= arr[index];
                set.get(i).remove(set.get(i).size() - 1);
                break;
            }
        }
        return isPossible;
    }
}
