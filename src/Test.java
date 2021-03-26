public class Test {
    public static int solve(int[] price) {
        int profit = 0;
        // Initializing variable
        // valley-peak approach
        /*
                           80
                           /
            30            /
           /  \          25
          /    15       /
         /      \      /
        2        10   /
                   \ /
                    8
         */
        for (int i = 1; i < price.length; i++) {
            // traversing through array from (i+1)th
            // position

            int sub = price[i] - price[i - 1];
            if (sub > 0)
                profit += sub;
        }
        return profit;
    }
}
