package questions.array;

public class Segregate0sAnd1s {
//    Q - https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
    public int[] solve(int[] arr) {
        int i = 0, j = 0;

        while (j < arr.length) {
            if (arr[j] == 1) {
                j++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
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
