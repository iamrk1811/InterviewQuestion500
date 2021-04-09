package questions.SearchAndSorting;

import java.util.Arrays;
import java.util.Comparator;

public class PermuteTwoArraysSuchThatSumOfEveryPairIsGreaterOrEqualToK {
//    Q - https://www.geeksforgeeks.org/permute-two-arrays-sum-every-pair-greater-equal-k/
    public boolean solve(Long[] a, long[] b, int n, int k) {
        Arrays.sort(a, new Comparator<Long>(){
            @Override
            public int compare(Long a, Long b) {
                if (a < b) return 1;
                else if (a == b) return 0;
                else return -1;
            }
        });
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[i] + b[i] < k) return false;
        }
        return true;

    }
}
