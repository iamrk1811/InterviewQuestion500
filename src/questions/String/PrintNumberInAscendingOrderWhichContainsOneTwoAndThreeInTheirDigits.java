package questions.String;

import java.util.ArrayList;
import java.util.Collections;

public class PrintNumberInAscendingOrderWhichContainsOneTwoAndThreeInTheirDigits {
//    Q - https://www.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/
    public ArrayList<Integer> solve(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int val : num) {
            if (contains(val)) {
                list.add(val);
            }
        }
        Collections.sort(list);
        return list;
    }
    private boolean contains(int val) {
        String str = Integer.toString(val);
        return str.contains("1") && str.contains("2") && str.contains("3");
    }
}
