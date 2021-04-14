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

        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        String res = new FindLargestWordInDictionaryByDeletingSomeCharactersOfGivenString().solve("abpcplea", list);
        System.out.println(res);
        Test.giveMeString("Find largest word in dictionary by deleting some characters of given string");
    }
}
