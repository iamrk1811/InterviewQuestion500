package questions.SearchAndSorting;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {
//    Q - https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
    public int solve(int[] arr) {
        int included = arr[0];
        int excluded = 0;
        for (int i = 1; i < arr.length; i++ ) {
            int temp = Math.max(included, excluded);

            included = excluded + arr[i];
            excluded = temp;
        }
        return Math.max(included, excluded);
    }
}
