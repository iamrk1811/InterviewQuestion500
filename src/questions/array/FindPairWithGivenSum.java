package questions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindPairWithGivenSum {
//    Q - https://practice.geeksforgeeks.org/problems/find-pair-given-difference/0
    public void solve2(int[] arr, int target) {
//        using hashing
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] - target;
            if (map.containsKey(x)) {
                int index = map.get(x);
                if (i != index) {
                    System.out.println("FOUND");
                    return;
                }
            }
        }
        System.out.println("NOT FOUND");
    }
    public void solve(int[] arr, int target) {
//        using sorting and binary search
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int newTarget = arr[i] - target;

            boolean res = binarySearch(arr, newTarget);

            if (res) {
                System.out.println("FOUND");
                return;
            }
        }
        System.out.println("NOT FOUND");
    }
    private boolean binarySearch(int[] arr, int target) {
        int low = 0, high =  arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            System.out.println("arr :" + arr[mid]);
            if (arr[mid] == target) {
                System.out.println("OKAY");
                return true;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high =  mid - 1;
            }
        }
        return false;
    }
}
