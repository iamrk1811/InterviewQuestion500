package questions.SearchAndSorting;

import java.util.ArrayList;

public class FindDuplicatesInAnArray {
    public ArrayList<Integer> solve(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] / n >= 2) {
                res.add(i);
            }
        }
        return res;
    }
}
