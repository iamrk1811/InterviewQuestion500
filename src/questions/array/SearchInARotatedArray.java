package questions.array;

public class SearchInARotatedArray {
    //    Q - https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
    public int solve(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] >= arr[low]) {
                // left side increasing order
                if (target <= arr[mid] && target >= arr[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right side increasing order
                if (target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
