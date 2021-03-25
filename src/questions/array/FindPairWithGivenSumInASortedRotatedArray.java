package questions.array;

public class FindPairWithGivenSumInASortedRotatedArray {
//    Q - https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
//    Hashing solution can be done in T -> O(N) S -> O(N)
//    But i am implementing binary search solution
    public boolean solve(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int tempTarget = target - arr[i];
            boolean res = binarySearch(arr, tempTarget);
            if (res)
                return true;
        }
        return false;
    }
    private boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return true;
            if (arr[mid] >= arr[low]) {
                if(target <= arr[mid] && target >= arr[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return false;
    }
}
