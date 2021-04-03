package questions.SearchAndSorting;

import java.util.Arrays;

public class CountTripletsWithSumSmallerThanAGivenValue {
//    Q - https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
    public int solve(int[] arr, int sum) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int low = i + 1, high = arr.length - 1;
            while (low < high) {
                if (arr[low] + arr[high] + arr[i] < sum) {
                    count += high - low;
                    low++;

                } else{
                    high--;
                }

            }
        }
        return count;
    }
}

