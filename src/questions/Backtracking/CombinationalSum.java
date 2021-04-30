package questions.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class CombinationalSum {
//    Q - https://www.geeksforgeeks.org/combinational-sum/
    public ArrayList<ArrayList<Integer>> solve(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(arr, 0, list, new ArrayList<>(), target);
        return list;
    }

    private void helper(int[] arr, int index, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> res, int target) {
        if (index == arr.length) {
            if (target == 0) {
                list.add(new ArrayList<>(res));
            }
            return;
        }
        if (arr[index] <= target) {
            res.add(arr[index]);
            helper(arr, index, list, res, target - arr[index]);
            res.remove(res.size() - 1);
        }

        helper(arr, index + 1, list, res, target);
    }
}
