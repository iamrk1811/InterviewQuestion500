package questions.OrderStatisticsHeapHash;

public class PancakeSorting {
//    Q - LeetCode 969
//    Q - https://www.geeksforgeeks.org/a-pancake-sorting-question/
public void pancakeSort(int[] arr) {
    if (isArraySorted(arr))
        return;

    for (int i = arr.length - 1; i >= 1; i--) {

        int maxIndex = findMax(arr, i);

        if (maxIndex != i) {
            reverse(arr, maxIndex);
            reverse(arr, i);
        }
    }
}
    int findMax(int[] arr, int lastIndex) {
        int maxIndex = 0;
        for (int i = 0; i <= lastIndex; i++) {
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
        return maxIndex;
    }
    void reverse(int[] arr, int index) {
        int low = 0, high = index;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    boolean isArraySorted(int[] arr) {
        if (arr.length == 1) return true;
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[prev] > arr[i]) {
                return false;
            } else {
                prev = i;
            }
        }
        return true;
    }
}
