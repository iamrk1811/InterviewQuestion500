package questions.array;

public class MinimumSwapsAndKTogether {
//    Q - https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
    public int solve(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int val : arr) {
            if (val <= k) count++;
        }

        int swapRequired = 0;

        for (int i = 0; i < count; i++) {
            if (arr[i] > k)
                swapRequired++;
        }

        int i = 0, j = count;

        int res = swapRequired;

        while (j < n) {
            // exclude arr[i]
            if (arr[i] > k) swapRequired--;
            // include arr[j]
            if (arr[j] > k) swapRequired++;

            res = Math.min(res, swapRequired);
            i++; j++;

        }
        return res;
    }
}
