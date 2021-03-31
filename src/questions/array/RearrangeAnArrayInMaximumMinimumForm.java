package questions.array;

public class RearrangeAnArrayInMaximumMinimumForm {
    public int[] solve(int[] arr) {
        int n = arr.length;
        int mod = arr[n-1] + 1;
        int low = 0, high = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + arr[high] % mod * mod;
                high--;
            } else {
                arr[i] = arr[i] + arr[low] % mod * mod;
                low++;
            }
        }

        for (int j = 0; j < n; j++) {
            arr[j] = arr[j] / mod;

        }
        return arr;
    }
}
