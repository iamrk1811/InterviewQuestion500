package questions.OrderStatisticsHeapHash;

public class FindTheSmallestPositiveNumberMissingFromAnUnsortedArray {
//    Q - https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
    public int solve(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] > 0 && arr[i] <= arr.length) {
                int index = arr[i] - 1;
                int prev = arr[i];

                swap(arr, i, index);

                if (arr[i] > arr.length || arr[i] == i + 1 || arr[i] == prev) {
                    i++;
                }

            } else {
                i++;
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return arr.length + 1;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
