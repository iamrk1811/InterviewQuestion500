package questions.SearchAndSorting;

public class FindMissingAndRepeating {
    public void solve(int[] arr) {
        long n = arr.length;
        long sumA = 0, sumN = 0;
        sumN = (n * (n + 1))/ 2;

        for (int val : arr) sumA += val;

        long sumA2 = 0, sumN2 = 0;

        sumN2 = (n * (n + 1) * (2 * n + 1)) / 6;

        for (int val : arr) sumA2 += Math.pow(val, 2);

        long xminusy = sumN - sumA;

        long x2minusy2 = sumN2 - sumA2;

        long x = (xminusy + x2minusy2) / 2;
        long y = x2minusy2 - x;

        System.out.println(x);
        System.out.println(y);
    }
}
