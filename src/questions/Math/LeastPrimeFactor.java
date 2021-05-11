package questions.Math;

import java.util.Arrays;

public class LeastPrimeFactor {
//    Q - https://practice.geeksforgeeks.org/problems/least-prime-factor5216/1#
    public int[] solve(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;


        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {

                arr[i] = i;

                for (int j = i * i; j <= n; j += i) {
                    if (arr[j] == 0)
                        arr[j] = i;
                }
            }
        }
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            res[i] = arr[i];
        }

        return res;
    }
}
