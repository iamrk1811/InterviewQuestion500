package questions.Backtracking;

import java.sql.Array;
import java.util.ArrayList;

public class TugOfWar {
//    Q - https://www.geeksforgeeks.org/tug-of-war/
    public void solve(int[] arr) {
        solution(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(res1);
        System.out.println(res2);
    }
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> res1 = new ArrayList<>();
    ArrayList<Integer> res2 = new ArrayList<>();
    private void solution(int[] arr, int index, ArrayList<Integer> set1, ArrayList<Integer> set2, int sum1, int sum2) {
        if (index == arr.length) {
            int difference = Math.abs(sum1 - sum2);
            if (difference < min) {
                min = difference;
                res1 = new ArrayList<>(set1);
                res2 = new ArrayList<>(set2);
            }
            return;
        }
        if (set1.size() < (arr.length) / 2) {
            set1.add(arr[index]);
            solution(arr, index + 1, set1, set2, sum1 + arr[index], sum2);
            set1.remove(set1.size() - 1);
        }
        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[index]);
            solution(arr, index + 1, set1, set2, sum1, sum2 + arr[index]);
            set2.remove(set2.size() - 1);
        }
    }
}
