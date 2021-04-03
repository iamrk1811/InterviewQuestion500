package questions.SearchAndSorting;

import java.util.Arrays;

public class FindPairGivenDifference {
//    Q - https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
//    I am not implementing the Hashing methode O(N)
    public void solve(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int newTarget = arr[i] - target;

            int index = binarySearch(arr, newTarget);
            if (index != -1) {
                System.out.println(arr[i]);
                System.out.println(arr[index]);
                break;
            }
        }
    }
    private int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
