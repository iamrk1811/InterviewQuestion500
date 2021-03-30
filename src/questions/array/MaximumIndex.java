package questions.array;

import java.util.Arrays;

public class MaximumIndex {
    //    Q - https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1
    public int solve(int[] arr, int n) {

        int[] rightMax = new int[n + 1];
        Arrays.fill(rightMax, Integer.MIN_VALUE);

        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }


        int res = 0;

        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1, ans = i;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (arr[i] <= rightMax[mid]) {
                    ans = Math.max(ans, mid);
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            res = Math.max(res, ans - i);
        }
        return res;

    }
    public int solve2(int[] arr, int n) {
        int[] rightMax = new int[n];
        int[] leftMin = new int[n];

        rightMax[n - 1] = arr[n - 1];
        leftMin[0] = arr[0];


        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int i = 0, j = 0;
        int res = -1;

        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}
