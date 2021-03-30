package questions.array;

public class NumberOfSubArraysWithMaximumValuesInGivenRange {
//    Q - https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
//    Q - https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
    public int solve(int[] arr, int L, int R) {
        int n = arr.length;

        int result = 0, start = -1, end = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > R) {
                // RESET VALUE
                start = i;
                end = i;

            } else if (arr[i] < L) {
                // OK VALUE
            } else {
                // NEEDED VALUE
                end = i;
            }
            result += end - start;
        }
        return result;
    }
}
