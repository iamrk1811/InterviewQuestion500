package questions.String;

import java.util.Arrays;

public class MakeLargestPalindromeByChangingAtMostKDigits {
//    Q - https://www.geeksforgeeks.org/make-largest-palindrome-changing-k-digits/
    public int[] solve(int[] arr, int k) {
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            if (arr[left] != arr[right]) {
                if (arr[left] < arr[right]) {
                    arr[left] = arr[right];

                } else {
                    arr[right] = arr[left];
                }
                visited[left] = visited[right] = true;
                k--;
            } else {
                left++; right--;
            }
        }
        if (k < 0) {
            System.out.println("NO");
            return new int[]{};
        } else if (k > 0) {
            if (arr.length % 2 != 0) arr[arr.length / 2] = 9;
        }
        left = 0; right = arr.length - 1;
        while (k > 0) {
            k--;
            if (visited[left] && visited[right]) {
                arr[left] = arr[right] = 9;
            }
            left++; right--;
        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
