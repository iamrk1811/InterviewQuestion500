package questions.array;

public class TrappingRainWatter {
//    Q - https://www.geeksforgeeks.org/trapping-rain-water/
    public int solve2(int[] arr) {
        int max = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int low = 0, high = arr.length - 1;

        while (low < high) {
            if (arr[low] < arr[high]) {
//                here is the possible maximum height
                if (arr[low] > leftMax) {
                    leftMax = arr[low];
                }
                max += leftMax - arr[low];
                low++;
            } else {
                if (arr[high] > rightMax) {
                    rightMax = arr[high];
                }
                max += rightMax - arr[high];
                high--;
            }
        }
        return max;
    }
    public int solve(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMax[0] = arr[0];
        rightMax[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        int trappedWatter = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            trappedWatter += min - arr[i];
        }
        return trappedWatter;
    }
}
