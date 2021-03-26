package questions.array;

public class SortArrayOf0s1sAnd2s {
//    Q - https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    public int[] solve(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 1) {
                j++;
            } else if (arr[j] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                swap(arr, j, k);
                k--;
            }
        }
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
