package questions.Greedy;

import java.util.Arrays;

public class FindMaximumHeightPyramidFromTheGivenArrayOfObjects {
//    Q - https://www.geeksforgeeks.org/find-maximum-height-pyramid-from-the-given-array-of-objects/
    public int solve(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int prevWidth = arr[0];
        int prevCount = 1;

        int ans = 1;
        int currentWidth = 0, currentCount = 0;
        for (int i = 1; i < n; i++) {
            currentCount++;
            currentWidth += arr[i];

            if (currentCount > prevCount && currentWidth > prevWidth) {
                prevCount = currentCount;
                prevWidth = currentWidth;
                ans++;
                currentCount = 0;
                currentWidth = 0;
            }
        }
        return ans;
    }
}
