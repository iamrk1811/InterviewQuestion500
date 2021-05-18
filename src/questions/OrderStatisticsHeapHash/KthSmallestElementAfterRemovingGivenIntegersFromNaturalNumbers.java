package questions.OrderStatisticsHeapHash;

public class KthSmallestElementAfterRemovingGivenIntegersFromNaturalNumbers {
//    Q - https://www.geeksforgeeks.org/k-th-smallest-element-removing-given-integers-natural-numbers-set-2/
//    Q - https://www.geeksforgeeks.org/k-th-smallest-element-removing-integers-natural-numbers/
    public int solve(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) k++;
            else break;
        }
        return k;
    }
}
