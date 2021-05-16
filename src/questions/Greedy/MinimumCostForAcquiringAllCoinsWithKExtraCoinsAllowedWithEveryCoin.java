package questions.Greedy;

import java.util.Arrays;

public class MinimumCostForAcquiringAllCoinsWithKExtraCoinsAllowedWithEveryCoin {
//    Q - https://www.geeksforgeeks.org/minimum-cost-for-acquiring-all-coins-with-k-extra-coins-allowed-with-every-coin/
    public int solve(int[] coins, int k) {
        int needCoin = (int) Math.ceil(1.0 * coins.length / (k + 1));
        int ans = 0;
        Arrays.sort(coins);
        for (int i = 0; i <= needCoin; i++) ans += coins[i];
        return ans;
    }
}
