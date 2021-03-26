package questions.array;

public class MaximumProfitByBuyingAndSellingAShareAtMostTwice {
//    Q - https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
    public int solve(int[] arr) {
//        solved using dynamic programming
        int[] leftDp = new int[arr.length];
        int[] rightDp = new int[arr.length];
        leftDp[0] = 0;
        rightDp[arr.length - 1] = 0;

        int maxProfit = 0;
        int leftMinBuy = arr[0];
        for (int i = 1; i < leftDp.length; i++) {
            if (leftMinBuy > arr[i]) {
                   leftMinBuy = arr[i];
            }

            maxProfit = arr[i] - leftMinBuy;

            leftDp[i] = Math.max(maxProfit, leftDp[i - 1]);
        }

        maxProfit = 0;
        int rightMax = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (rightMax < arr[i]) {
                rightMax = arr[i];
            }

            maxProfit = rightMax - arr[i];

            rightDp[i] = Math.max(maxProfit, rightDp[i + 1]);
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, leftDp[i] + rightDp[i]);
        }
        return max;
    }
}
