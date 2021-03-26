package questions.array;

import java.util.Arrays;

public class MaximumLengthBitonicSubArray {
//    Q - https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
    public int solve(int[] arr) {

        int n = arr.length;

        int[] incrementDp = new int[n];
        int[] decrementDp = new int[n];

        incrementDp[0] = 1;
        decrementDp[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            if (arr[i - 1] < arr[i]) {
                max = incrementDp[i - 1];
            }
            incrementDp[i] = max + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            if (arr[i + 1] < arr[i]) {
                max = decrementDp[i + 1];
            }
            decrementDp[i] = max + 1;
        }
        System.out.println(Arrays.toString(incrementDp));
        System.out.println(Arrays.toString(decrementDp));
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, incrementDp[i] + decrementDp[i] - 1);
        }
        return maxLength;
    }
}
