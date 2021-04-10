package questions.String;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GenerateAllBinaryStringsFromGivenPattern {
    public List<String> solve2(String str) {
        Queue<String> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();

        queue.add(str);

        while (!queue.isEmpty()) {

            String temp = queue.peek();

//            Index of first ?
            int index = temp.indexOf('?');

            if (index != -1) {
                String strWith0 = temp.substring(0, index) + "0" +temp.substring(index + 1);
                String strWith1 = temp.substring(0, index) + "1" +temp.substring(index + 1);

                queue.add(strWith0);
                queue.add(strWith1);
            } else {
                res.add(temp);
            }
            queue.remove();
        }
        return res;
    }
    public List<String> solve(String s)
    {
        List<String> res = new ArrayList<>();
        return help(s.toCharArray(), 0, res);
    }
    private List<String> help(char[] arr, int index, List<String> res) {
        if (index == arr.length) {
            res.add(new String(arr));
            return res;
        }

        if (arr[index] == '?') {

            arr[index] = '0';
            help(arr, index + 1, res);

            arr[index] = '1';
            help(arr, index + 1, res);

            arr[index] = '?';
        } else {
            help(arr, index + 1, res);
        }
        return res;
    }
}
