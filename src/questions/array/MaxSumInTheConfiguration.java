package questions.array;

public class MaxSumInTheConfiguration {
//    Q - https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1#
    public int solve2(int[] arr) {
        int n = arr.length;
        int sumProduct = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sumProduct += arr[i] * i;
            sum += arr[i];
        }
        int res = sumProduct;
        for (int i = 1; i < n; i++) {
            int next = sumProduct - (sum - arr[i - 1]) + arr[i - 1] * (n - 1);
            sumProduct = next;
            res = Math.max(res, next);
        }
        return res;
    }
    public int solve(int[] arr) {
//        O (N^2)
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        while (n-- > 0) {
            rotateArray(arr);
            int currentMax = 0;
            for (int i = 0; i < arr.length; i++) {
                currentMax += arr[i] * i;
            }
            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }
    public void rotateArray(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }
}
