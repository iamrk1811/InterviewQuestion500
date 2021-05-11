package questions.Math;

import java.util.ArrayList;

public class PrimeFactorizationUsingSieve {
//    Q - https://www.geeksforgeeks.org/prime-factorization-using-sieve-olog-n-multiple-queries/
    public ArrayList<Integer> solve(int number) {
        int[] arr = new int[number + 1];
        arr[1] = 1;
        for (int i = 2; i <= number; i++) {
            if (arr[i] == 0) {
                arr[i] = i;

                for (int j = i * i; j <= number; j += i) {
                    if (arr[j] == 0) {
                        arr[j] = i;
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (number != 1) {
            int x = arr[number];
            number /= arr[number];
            res.add(x);
        }

        return res;
    }
}
