package questions.Backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PrintAllPalindromicPartitionsOfAString {
//    Q - https://www.geeksforgeeks.org/print-palindromic-partitions-string/
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solve(String str) {
        helper(str, new ArrayList<>());
        return res;
    }
//    private void helper(String str, String ans) {
//        if (str.length() == 0) {
//            System.out.println(ans);
////            res.add(ans);
//            return;
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            String prefix = str.substring(0, i + 1);
//            if (new StringBuilder(prefix).reverse().toString().equals(prefix)) {
////                ans.add(prefix);
//                helper(str.substring(i + 1), ans + prefix + " ");
//            }
//        }
//    }
    private void helper(String str, ArrayList<String> ans) {
        if (str.length() == 0) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            if (new StringBuilder(prefix).reverse().toString().equals(prefix)) {
                ans.add(prefix);
                helper(str.substring(i + 1), ans);
                ans.remove(prefix);
            }
        }
    }
}
