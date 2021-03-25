package questions.array;

public class StockBuySellToMaximizeProfit {
//    Q - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
    public int solve(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
}
