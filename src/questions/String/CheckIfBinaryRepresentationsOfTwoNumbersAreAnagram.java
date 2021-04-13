package questions.String;

import java.util.Arrays;

public class CheckIfBinaryRepresentationsOfTwoNumbersAreAnagram {
//    Q - https://www.geeksforgeeks.org/check-binary-representations-two-numbers-anagram/
    public boolean solve2(int a, int b) {
        if (Integer.bitCount(a) != Integer.bitCount(b)) return false;
        return true;
    }
    public boolean solve(int a, int b) {
        int[] aArray = new int[8];
        int[] bArray = new int[8];

        int i = 0;
        while (a > 0) {
            aArray[i++] = a % 2;
            a /= 2;
        }

        i = 0;
        while (b > 0) {
            bArray[i++] = b % 2;
            b /= 2;
        }

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        for (i = 0; i < 8; i++) {
            if (aArray[i] != bArray[i]) return false;
        }
        return true;
    }
}
