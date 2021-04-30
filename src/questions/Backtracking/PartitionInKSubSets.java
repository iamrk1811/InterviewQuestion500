package questions.Backtracking;

import java.util.ArrayList;

public class PartitionInKSubSets {
    public ArrayList<ArrayList<Integer>> solve(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(new ArrayList<>());
        }
        partition(arr, 0, 0, k, finalRes, res);
        for (ArrayList<Integer> list : finalRes) {
            System.out.println(list);
        }
        return res;
    }
    private void partition(int[] arr, int index, int count, int k,ArrayList<ArrayList<Integer>> finalRes, ArrayList<ArrayList<Integer>> res) {
        if (index == arr.length) {
            if (count == k) {
                for (ArrayList<Integer> list : res) {
                    finalRes.add(new ArrayList<>(list));
                }
            }
            return;
        }

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() > 0) {
                res.get(i).add(arr[index]);
                partition(arr, index + 1, count, k, finalRes, res);
                res.get(i).remove(res.get(i).size() - 1);
            } else {
                res.get(i).add(arr[index]);
                partition(arr, index + 1, count + 1, k, finalRes, res);
                res.get(i).remove(res.get(i).size() - 1);
                break;
            }
        }
    }
}
