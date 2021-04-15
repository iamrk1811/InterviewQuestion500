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
        int res = new CountDistinctSubsequences().solve("gfg");
        System.out.println(res);
        Test.giveMeString("Given a string find its first non repeating character");
    }
}
