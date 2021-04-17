import questions.SearchAndSorting.*;
import questions.String.*;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int res = new LexicographicRankOfAString().solve("acb");
        System.out.println(new PrintNumberInAscendingOrderWhichContainsOneTwoAndThreeInTheirDigits().solve(new int[]{12, 232, 456, 234}));


        Test.giveMeString("Find Excel column name from a given column number");
    }
}
