import questions.SearchAndSorting.*;
import questions.String.GenerateAllBinaryStringsFromGivenPattern;
import questions.String.GroupWordsWithSameSetOfCharacters;
import questions.String.MinimumWindowSubstring;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String res = new MinimumWindowSubstring().solve("ADOBECODEBANC", "ABC");
        System.out.println(res);
        Test.giveMeString("Smallest window that contains all characters of string itself");
    }
}
