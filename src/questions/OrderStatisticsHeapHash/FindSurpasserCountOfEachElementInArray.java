package questions.OrderStatisticsHeapHash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class FindSurpasserCountOfEachElementInArray {
//    Q - https://www.geeksforgeeks.org/find-surpasser-count-of-each-element-in-array/
    public int[] solve(int[] arr) {
        int n = arr.length;
        int[] original = Arrays.copyOf(arr, n);

        int[] aux = Arrays.copyOf(arr, n);

        HashMap<Integer, Integer> map = new HashMap<>();

        mergesort(arr, aux, 0, n - 1, map);

        for (int i = 0; i < n; i++) {
            original[i] = map.getOrDefault(original[i], 0);
        }

        return original;
    }

    private void mergesort(int[] arr, int[] aux, int low, int high, Map<Integer, Integer> map) {
        if (high == low) {
            return;
        }
        int mid = (low + high) / 2;
        mergesort(arr, aux, low, mid, map);
        mergesort(arr, aux, mid + 1, high, map);
        merge(arr, aux, low, mid, high, map);
    }

    private void merge(int[] arr, int[] aux, int low, int mid, int high, Map<Integer, Integer> map) {
        int k = low, i = low, j = mid + 1;
        int count = 0;
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                // update surpasser count of `arr[i]`
                map.put(arr[i], map.getOrDefault(arr[i], 0) + count);

                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
                count++;
            }
        }

        // copy remaining elements
        while (i <= mid) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + count);
            aux[k++] = arr[i++];
        }
//        get back to original
        while (low <= high) {
            arr[low] = aux[low];
            low++;
        }
    }
}