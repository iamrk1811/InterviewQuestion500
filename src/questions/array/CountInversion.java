package questions.array;

public class CountInversion {
//    Q - https://www.geeksforgeeks.org/counting-inversions/
    public int solve(int[] arr) {
        boolean isArraySorted = true;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i+1]) {
                isArraySorted = false;
            }
        }

        if (isArraySorted) return 0;

        int count = mergeSortCount(arr, 0, arr.length - 1);
        return count;
    }
    private int mergeSortCount(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSortCount(arr, low, mid);
            count += mergeSortCount(arr, mid + 1, high);
            count += mergeTwoSortedArray(arr, low, mid, high);
        }
        return count;
    }
    private int mergeTwoSortedArray(int[] arr, int low, int mid, int high) {
        int count = 0;

        int[] arr1 = new int[mid - low + 1];
        int[] arr2 = new int[high - mid];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[low + i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[mid + i + 1];
        }
        int i = 0, j = 0, k = low;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                arr[k] = arr2[j];
                count += arr1.length - i;
                j++;
            } else {
                arr[k] = arr1[i];
                i++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
        return count;
    }
}
