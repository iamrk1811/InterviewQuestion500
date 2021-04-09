package questions.SearchAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindTheLargestMultipleOfThree {
//    Q - https://www.geeksforgeeks.org/find-largest-multiple-3-array-digits-set-2-time-o1-space/
    public String solve(int[] digits) {
//         Handle Edge cases for leading zeros

        int zeros = 0;
        while (zeros < digits.length) {
            if (digits[zeros] == 0) {
                zeros++;
            } else {
                break;
            }
        }
        if (zeros == digits.length) return "0";
//         Calculate the total sum
        long sum = 0;
        int[] remain = new int[digits.length - zeros];
        int index = 0;
        for (int i = zeros; i < digits.length; i++) {
            sum += digits[i];
            remain[index] = digits[i];
            index++;
        }

//         Sorting in increasing order because we want to delete smaller number
        Arrays.sort(remain);


//         Remove elements
        ArrayList<Integer> list = new ArrayList<>();

        if (sum % 3 == 0) {
            for (int val : remain) {
                list.add(val);
            }
        } else if (sum % 3 == 1) {

            boolean isFound = false;
            for (int i = 0; i < remain.length; i++) {
                if (remain[i] % 3 == 1 && !isFound) {
                    isFound = true;
                } else {
                    list.add(remain[i]);
                }
            }

            if (!isFound) {
                int removeCount = 0;
                list = new ArrayList<>();
                for (int i = 0; i < remain.length; i++) {
                    if (remain[i] % 3 == 2 && removeCount < 2) {
                        removeCount++;
                    } else {
                        list.add(remain[i]);
                    }
                }
            }

        } else if (sum % 3 == 2) {
            boolean isFound = false;
            for (int i = 0; i < remain.length; i++) {
                if (remain[i] % 3 == 2 && !isFound) {
                    isFound = true;
                } else {
                    list.add(remain[i]);
                }
            }
            if (!isFound) {
                list = new ArrayList<>();
                int removeCount = 0;
                for (int i = 0; i < remain.length; i++) {
                    if (remain[i] % 3 == 1 && removeCount < 2) {
                        removeCount++;
                    } else {
                        list.add(remain[i]);
                    }
                }
            }
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a < b) {
                    return 1;
                } else if (a == b) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        StringBuilder str = new StringBuilder();
        for (int val : list) {
            str.append(val);
        }
        return str.toString();
    }
}
