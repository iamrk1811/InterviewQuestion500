package questions.array;

public class MoveAllZeroesToEndOfArray {
//    Q - https://www.geeksforgeeks.org/move-zeroes-end-array/
    public int[] solve(int[] arr) {
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                j++;
            } else {
                swap(arr, i, j);
                j++;
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
