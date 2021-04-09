package questions.SearchAndSorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortAccordingToSetCountBits {
//    Q - https://www.geeksforgeeks.org/sort-array-according-count-set-bits/
    public Integer[] solve(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                int aCountBit = Integer.bitCount(a);
                int bCountBit = Integer.bitCount(b);

                if (aCountBit < bCountBit) {
                    return 1;
                } else if (aCountBit == bCountBit) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return arr;
    }
}
