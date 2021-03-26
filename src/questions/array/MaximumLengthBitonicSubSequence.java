package questions.array;

public class MaximumLengthBitonicSubSequence {
    public int solve(int[] arr) {
        int n = arr.length;
        int[] incrementDp = new int[n];
        int[] decrementDp = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    max = Math.max(max, incrementDp[j]);
                }
            }
            incrementDp[i] = max + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] <= arr[i]) {
                    max = Math.max(max, decrementDp[j]);
                }
            }
            decrementDp[i] = max + 1;
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, incrementDp[i] + decrementDp[i] - 1);
        }
        return maxLength;
    }
}
