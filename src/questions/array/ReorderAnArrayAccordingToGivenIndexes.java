package questions.array;

public class ReorderAnArrayAccordingToGivenIndexes {
//    Q - https://www.geeksforgeeks.org/reorder-a-array-according-to-given-indexes/
    public int[] solve(int[] arr, int[] index) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (index[i] != i) {
                swap(arr, index, i, index[i]);
            } else {
                i++;
            }
        }
        return arr;
    }
    private void swap(int[] arr, int[] index, int i, int j) {
        int tempValue = arr[i];
        int tempIndex = index[i];

        arr[i] = arr[j];
        index[i] = index[j];

        arr[j] = tempValue;
        index[j] = tempIndex;
    }
}
