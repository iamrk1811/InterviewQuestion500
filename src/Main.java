import questions.SearchAndSorting.*;
import questions.String.*;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        int res = new LongestNonPalindromicSubstring().solve("malayalam");
        System.out.println(res);

        Test.giveMeString("Longest Non palindromic substring");
    }
}
