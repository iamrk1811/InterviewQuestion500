package questions.Greedy;

import java.util.Arrays;

public class FindSmallestNumberWithGivenNumberOfDigitsAndSumOfDigits {
//    Q - https://www.geeksforgeeks.org/find-smallest-number-with-given-number-of-digits-and-digit-sum/
    public int solve(int sum, int numOfDigits) {
        if (sum == 0) return numOfDigits == 1 ? 0 : -1;

        if (sum > 9 * numOfDigits) return -1;

        int[] arr = new int[numOfDigits];

        sum -= 1;

        for (int i = arr.length - 1; i >= 1; i--) {
            if (sum > 9) {
                arr[i] = 9;
                sum -= 9;
            } else {
                arr[i] = sum;
                sum = 0;
            }
        }
        arr[0] = sum + 1;

        int res = 0;
        for (int d : arr) {
            res = res * 10 + d;
        }
        return res;
    }
}
