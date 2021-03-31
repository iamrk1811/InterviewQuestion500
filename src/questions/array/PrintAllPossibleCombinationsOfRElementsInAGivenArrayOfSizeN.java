package questions.array;

import java.util.Arrays;

public class PrintAllPossibleCombinationsOfRElementsInAGivenArrayOfSizeN {
//    Q - https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
    public void solve(int[] arr, int R) {
        printCombination(arr, new int[R], R, 0, 0);
    }
    private void printCombination(int[] arr, int[] data, int R, int arrayIndex, int dataIndex) {
        if (dataIndex == R) {
            System.out.println(Arrays.toString(data));
            return;
        }
        if (arrayIndex >= arr.length)
            return;

        data[dataIndex] = arr[arrayIndex];
        printCombination(arr, data, R, arrayIndex + 1, dataIndex + 1);
        printCombination(arr, data, R, arrayIndex + 1, dataIndex);
    }
}
