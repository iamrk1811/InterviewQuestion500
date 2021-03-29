package questions.array;

public class MaximumDifferenceBetweenTwoElementsSuchThatLargerElementAppearsAfterTheSmallerNumber {
//    Q - https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
    public int solve(int[] arr) {
        int max = 0;
        int minFoundSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (minFoundSoFar > arr[i])
                minFoundSoFar = arr[i];
            max = Math.max(max, arr[i] - minFoundSoFar);
        }
        return max;
    }
}
