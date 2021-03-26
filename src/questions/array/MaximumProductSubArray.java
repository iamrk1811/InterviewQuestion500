package questions.array;

public class MaximumProductSubArray {
//    Q - https://www.geeksforgeeks.org/maximum-product-subarray/

    public long solve(long[] arr) {
        int n = arr.length;
        long max = 1, min = 1, product = 0;
        for (int i = 0; i < n; i++) {
            long x = arr[i];

            if (x > 0) {
                // Positive value
                max = max * x;
                min = Math.min(min * x, 1);


            } else if (x == 0) {
                // Zero
                max = min = 1;

            } else {
                // Negative value
                long newMin =  max;
                max = Math.max(min * x, 1);
                min = newMin * x;

            }

            product = Math.max(max, product);
        }
        return product;
    }
}
