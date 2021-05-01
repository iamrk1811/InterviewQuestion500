package questions.Backtracking;

public class FindMaximumNumberPossibleByDoingAtMostKSwaps {
    //    Q - https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
    public String solve(String str, int k) {
        boolean isDecreasing = true;
        int first = Integer.parseInt(str.charAt(0) + "");
        for (int i = 0; i < str.length(); i++) {
            if (first < Integer.parseInt(str.charAt(i) + "")) {
                isDecreasing = false;
                break;
            }
            first = Integer.parseInt(str.charAt(i) + "");
        }
        if (isDecreasing) return str;

        solution(str.toCharArray(), 0, k);
        return Integer.toString(max);
    }

    static int max = Integer.MIN_VALUE;

    private void solution(char[] arr, int index, int k) {
        max = Math.max(max, Integer.parseInt(new String(arr)));

        if (k == 0) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Integer.parseInt(arr[i] + "") < Integer.parseInt(arr[j] + "")) {
                    char ch = arr[i];
                    arr[i] = arr[j];
                    arr[j] = ch;

                    solution(arr, i, k - 1);

                    ch = arr[i];
                    arr[i] = arr[j];
                    arr[j] = ch;
                }
            }
        }
    }
}
