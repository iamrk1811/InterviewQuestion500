package questions.array;

import java.util.Arrays;

public class MinimumPlatform {
//    Q - https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    public int solve(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int maxPlatform = 1, need = 1;

        int i = 1, j = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                maxPlatform++;
                i++;
            } else {
                maxPlatform--;
                j++;
            }
            need = Math.max(need, maxPlatform);
        }
        return need;
    }
}
