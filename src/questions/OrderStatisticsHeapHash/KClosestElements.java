package questions.OrderStatisticsHeapHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KClosestElements {
//    Q - https://leetcode.com/problems/find-k-closest-elements/
public List<Integer> solve(int[] arr, int k, int x) {
    int mid = binarySearch(arr, x);

    int low = mid - 1, high = mid;

    List<Integer> list = new ArrayList<>();


    while (low >= 0 && high < arr.length && k > 0) {
        if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
            list.add(arr[low--]);
        } else {
            list.add(arr[high++]);
        }
        k--;
    }



    while (k > 0 && low >= 0) {
        list.add(arr[low--]);
        k--;
    }
    while (k > 0 && high < arr.length) {
        list.add(arr[high++]);
        k--;
    }

    Collections.sort(list);
    return list;
}
    int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == x) break;

            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }
}
