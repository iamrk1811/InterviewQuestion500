package questions.SearchAndSorting;

import java.util.Arrays;

public class FindNumberOfPairs {
    //    Q -https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
    public long countPairs(int x[], int y[], int m, int n) {
        long ans = 0;
        int zeros = 0, ones = 0, twos = 0, threes = 0, fours = 0;

        Arrays.sort(x);
        Arrays.sort(y);

        for (int val : y) {
            if (val == 0) zeros++;
            if (val == 1) ones++;
            if (val == 2) twos++;
            if (val == 3) threes++;
            if (val == 4) fours++;
        }

        for (int i = 0; i < m; i++) {
            int val = x[i];
            if (val != 0) {
                if (val == 1) {
                    ans += zeros;
                } else if (val == 2) {
                    int index = getIndex(y, 2);
                    if (index != -1) {
                        ans += n - index;
                    }
                    ans -= threes;
                    ans -= fours;
                    ans += zeros + ones;
                } else {
                    int index = getIndex(y, val);
                    if (index != -1) {
                        ans += n - index;
                    }
                    ans += zeros + ones;
                    if (val == 3) {
                        ans += twos;
                    }
                }
            }
        }
        return ans;
    }

    private int getIndex(int[] arr, int val) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > val) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
