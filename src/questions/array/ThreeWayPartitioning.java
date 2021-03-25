package questions.array;

public class ThreeWayPartitioning {
    public int[] solve(int[] arr, int a, int b) {
        int i = 0, j = 0, k = arr.length - 1;

        while (i <= k) {
            if (arr[i] < a) {
                swap(arr, i, j);
                j++; i++;
            } else if (arr[i] > b) {
                swap(arr, i, k);
                k--;
            } else {
                i++;
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
