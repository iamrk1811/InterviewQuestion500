import java.util.*;

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

    //    TEST TODO
}
