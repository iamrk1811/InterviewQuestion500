package questions.array;

public class FindTheSmallestPositiveIntegerValueThatCannotBeRepresentedAsSumOfAnySubset {
//    Q - https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
    public long solve(int[] arr) {
        long ans = 1;
        for (int j : arr) {
            if (j > ans)
                return ans;
            ans += j;
        }
        return ans;
    }
}
