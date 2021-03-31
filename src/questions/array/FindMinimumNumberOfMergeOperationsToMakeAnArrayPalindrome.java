package questions.array;

public class FindMinimumNumberOfMergeOperationsToMakeAnArrayPalindrome {
//    Q -   https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
    public int solve(int[] arr) {
        int i = 0, j = arr.length - 1, ans = 0;

        while (i <= j) {
            if (arr[i] == arr[j]) {
                i++; j--;
            } else if (arr[i] < arr[j]) {
                i++;
                arr[i] += arr[i - 1];
                ans++;
            } else {
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }
        }
        return ans;
    }
}
