package questions.array;

public class MaximumCircularSubArraySum {
//    Q - https://leetcode.com/problems/maximum-sum-circular-subarray/
//    Q - https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
    public int solve(int[] A) {
        long totalSum = 0;
        for (int val : A) totalSum += val;

        long simpleKadane = kadane(A);

//         reverse sign
        for (int i = 0; i < A.length; i++)
            A[i] = -A[i];

        long reverseKadane =  kadane(A);

        reverseKadane = totalSum + reverseKadane;

        long max = reverseKadane == 0 ? simpleKadane : Math.max(reverseKadane, simpleKadane);
        return (int) max;
    }
    private long kadane(int[] arr) {
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        for (int val : arr) {
            currentSum += val;
            if (maxSum < currentSum)
                maxSum = currentSum;
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
