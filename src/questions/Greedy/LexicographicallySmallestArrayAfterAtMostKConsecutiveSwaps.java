package questions.Greedy;

public class LexicographicallySmallestArrayAfterAtMostKConsecutiveSwaps {
//    Q - https://www.geeksforgeeks.org/lexicographically-smallest-array-k-consecutive-swaps/
    public int[] solve(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n - 1 && k > 0; i++) {

            int position = i; // store smallest element's index till k swaps

            for (int j = i + 1; j < n; j++) {
                if (j - i > k) break;

                if (arr[j] < arr[position]) {
                    position = j;
                }
            }

            for (int j = position; j > i; j--) {
                swap(arr, j, j - 1);
            }
            k -= position - i;
        }
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
