package questions.array;


public class FindSubArrayWithGivenSum {
//    Q - https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

    public void solve(int[] arr, int k) {
        int left = 0;
        int right = 1;
        int currentSum = arr[left];

        int startIndex  = -1;
        int endIndex = -1;
        while (right < arr.length) {
            if (k == currentSum) {
                startIndex = left;
                endIndex = right;
                break;
            }

            if (currentSum > k && left < right) {
                currentSum -= arr[left];
                left++;
            }else if (currentSum < k) {
                currentSum += arr[right];
                right++;
            }
        }

        System.out.println(startIndex);
        System.out.println(endIndex);

    }
}
