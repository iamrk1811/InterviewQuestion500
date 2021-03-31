package questions.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeGivenNumbersToFormTheBiggestNumber {
//    Q - https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
    public String solve(String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;

                if (ab.compareTo(ba) > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        StringBuilder res = new StringBuilder();
        for (String val : arr) {
            res.append(val);
        }
        return res.toString();
    }
}
