package questions.array;

public class EquilibriumIndexOfAnArray {
//    Q - https://leetcode.com/problems/find-pivot-index/
    public int solve2(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 1;
        }


        long totalSum = 0;
        for (long val : arr) totalSum += val;

        int currentSum = 0;
        int idx = 0;
        for (long val : arr) {
            totalSum -= val;

            if (totalSum == currentSum) {
                return idx;
            }

            currentSum += val;
            idx++;
        }
        return -1;
    }
}
