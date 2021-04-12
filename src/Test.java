import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Test {
    public static void giveMeString(String str) {
        String[] strArray = str.split(" ");
        StringBuilder res = new StringBuilder();

        for (String temp : strArray) {
            char firstChar = temp.charAt(0);
            if (firstChar >= 97)
                firstChar -= 32;
            String newString = firstChar + temp.substring(1);

            res.append(newString);
        }

        System.out.println(res);
    }
}
